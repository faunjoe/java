package com.faunjoe.solution.java.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-29 23:56
 */
public class ThreadPoolExecutorBuild {

    public static void main(String[] args) {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) buildThreadPoolExecutor();


        while (true) {
            System.out.println("ActiveCount: " + executorService.getActiveCount());
            System.out.println("CorePoolSize: " + executorService.getCorePoolSize());
            System.out.println("Queue: " + executorService.getQueue().size());
            System.out.println("MaximumPoolSize: " + executorService.getMaximumPoolSize());
            System.out.println("===================================");
        }

    }

    private static ExecutorService buildThreadPoolExecutor() {

        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), r -> {
            Thread t = new Thread(r);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy());

        System.out.println("The ThreadPoolExecutor create done.");

        executorService.execute(() -> sleepSeconds(100));
        executorService.execute(() -> sleepSeconds(10));
        executorService.execute(() -> sleepSeconds(10));

        return executorService;
    }

    private static void sleepSeconds(long seconds) {

        try {
            System.out.println("* " + Thread.currentThread().getName() + " *");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

