package com.faunjoe.solution.java.thread.simplepool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-25 10:38
 */
public class SimpleThreadPool2 extends Thread {

    private int size;

    private int queueSize;

    private int min;

    private int max;

    private int active;

    private final static int DEFAULT_SIZE = 10;

    private final static int DEFAULT_TASK_QUEUE_SIZE = 2000;

    private static volatile int seq = 0;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    private volatile boolean destory = false;

    private final DiscardPolicy discardPolicy;

    private final static DiscardPolicy DEFAULT_DISCARD_POLICY = () -> {
        throw new DiscardException("Discard This Task.");
    };

    public SimpleThreadPool2() {
        this(4, 8, 12, DEFAULT_TASK_QUEUE_SIZE, DEFAULT_DISCARD_POLICY);
    }

    public SimpleThreadPool2(int min, int active, int max, int queueSize, DiscardPolicy discardPolicy) {
        this.min = min;
        this.active = active;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }


    private void init() {
        for (int i = 0; i < this.min; i++) {
            createWorkerTask();
        }
        this.size = min;
        this.start();
    }

    public void submit(Runnable runnable) {
        if (destory) {
            throw new IllegalStateException("The thread pool already destory and not allow submit task.");
        }
        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() > queueSize)
                discardPolicy.discard();
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    @Override
    public void run() {
        while (!destory) {
            System.out.printf("Pool#Min:%d,Active:%d,Max:%d,Current:%d,QueueSize:%d\n",
                    this.min, this.active, this.max, this.size, TASK_QUEUE.size());

            try {
                Thread.sleep(1000);

                // 扩容
                if (TASK_QUEUE.size() > active && size < active) {
                    for (int i = size; i < active; i++) {
                        createWorkerTask();
                    }
                    System.out.println("The pool incremented to active");
                    size = active;
                } else if (TASK_QUEUE.size() > max && size < max) {
                    for (int i = size; i < max; i++) {
                        createWorkerTask();
                    }
                    System.out.println("The pool incremented to max");
                    size = max;
                }

                //缩减
                if (TASK_QUEUE.isEmpty() && size > active) {
                    synchronized (TASK_QUEUE) {
                        int releaseSize = size - active;

                        while (releaseSize > 0) {

                            Iterator<WorkerTask> it = THREAD_QUEUE.iterator();

                            while (it.hasNext()) {
                                if (releaseSize <= 0)
                                    break;

                                WorkerTask task = it.next();
                                if (task.taskState != TaskState.RUNNING) {
                                    task.close();
                                    task.interrupt();
                                    it.remove();
                                    releaseSize--;
                                }
                            }
                        }
                        System.out.println("The pool reduced to active");
                        size = active;
                    }
                } else if (TASK_QUEUE.isEmpty() && size > min) {
                    synchronized (TASK_QUEUE) {
                        int releaseSize = size - min;

                        while (releaseSize > 0) {
                            Iterator<WorkerTask> it = THREAD_QUEUE.iterator();

                            while (it.hasNext()) {
                                if (releaseSize <= 0)
                                    break;

                                WorkerTask task = it.next();
                                if (task.taskState != TaskState.RUNNING) {
                                    task.close();
                                    task.interrupt();
                                    it.remove();
                                    releaseSize--;
                                }
                            }
                        }
                        System.out.println("The pool reduced to min");
                        size = min;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createWorkerTask() {
        WorkerTask task = new WorkerTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public boolean getDestory() {
        return destory;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getActive() {
        return active;
    }

    public void shutDown() {
        while (!TASK_QUEUE.isEmpty()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int initVal = THREAD_QUEUE.size();
        while (initVal > 0) {
            for (WorkerTask task : THREAD_QUEUE) {
                if (task.getTaskState() == TaskState.BLOCKED) {
                    task.interrupt();
                    task.close();
                    initVal--;
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        this.destory = true;
        System.out.println("The thread pool disposed.");
    }

    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    public static class DiscardException extends RuntimeException {

        public DiscardException(String message) {
            super(message);
        }
    }

    public interface DiscardPolicy {

        void discard() throws DiscardException;
    }

    private static class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        public TaskState getTaskState() {
            return this.taskState;
        }

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            //e.printStackTrace();
                            System.out.println("-----Close------");
                            break OUTER;
                        }
                    }

                    runnable = TASK_QUEUE.removeFirst();
                }

                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) {
        SimpleThreadPool2 threadPool = new SimpleThreadPool2();
        //SimpleThreadPool threadPool = new SimpleThreadPool(6, 10, SimpleThreadPool.DEFAULT_DISCARD_POLICY);

        for (int i = 0; i < 100; i++) {
            try {
                threadPool.submit(() -> {
                    System.out.println("The task be serviced by " + Thread.currentThread() + " start.");

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(
                            "The task be serviced by " + Thread.currentThread() + " finished.");
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadPool.shutDown();
//
//        threadPool.submit(() -> System.out.println("============"));
    }
}
