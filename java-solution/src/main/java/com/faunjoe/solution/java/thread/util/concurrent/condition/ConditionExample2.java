package com.faunjoe.solution.java.thread.util.concurrent.condition;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-27 23:35
 */
public class ConditionExample2 {

    private final static ReentrantLock lock = new ReentrantLock();

    private final static Condition product_cond = lock.newCondition();
    private final static Condition consume_cond = lock.newCondition();

    private final static LinkedList<Long> timestamp_pool = new LinkedList<>();

    private final static int MAX_CAPACITY = 100;


    public static void main(String[] args) {
        IntStream.range(0,6).boxed().forEach(ConditionExample2::beginProduce);
        IntStream.range(0,15).boxed().forEach(ConditionExample2::beginConsume);

        for(;;){
            sleep(5000);
            System.out.println("=============================");
            System.out.println("product_cond.getWaitQueueLength > "+lock.getWaitQueueLength(product_cond));
            System.out.println("consume_cond.getWaitQueueLength > "+lock.getWaitQueueLength(consume_cond));
        }
    }

    private static void beginProduce(int i) {

        new Thread(() -> {
            for (; ; ) {
                produce();
                sleep(1000);
            }
        }, "P-" + i).start();

    }

    private static void beginConsume(int i) {

        new Thread(() -> {
            for (; ; ) {
                consume();
                sleep(1000);
            }
        }, "C-" + i).start();

    }

    private static void produce() {
        try {
            lock.lock();
            while (timestamp_pool.size() >= MAX_CAPACITY) {
                product_cond.await();
            }

            long value = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "-P-" + value);
            timestamp_pool.addLast(value);

            consume_cond.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void consume() {
        try {
            lock.lock();
            while (timestamp_pool.isEmpty()) {
                consume_cond.await();
            }

            long value = timestamp_pool.removeFirst();
            System.out.println(Thread.currentThread().getName() + "-C-" + value);
            product_cond.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void sleep(long sec) {
        try {
            TimeUnit.MILLISECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
