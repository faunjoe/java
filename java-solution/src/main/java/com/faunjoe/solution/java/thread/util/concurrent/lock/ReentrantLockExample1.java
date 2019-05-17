package com.faunjoe.solution.java.thread.util.concurrent.lock;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-27 12:04
 */
public class ReentrantLockExample1 {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        IntStream.range(0, 2).forEach(i -> new Thread() {
            @Override
            public void run() {
                needLock();

                //needLockBySync();
            }
        }.start());
    }

    public static void needLock() {

        try {
            lock.lock();
            Optional.of("The thread-" + Thread.currentThread().getName() + " get lock and will do working.")
                    .ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void needLockBySync() {
        synchronized (ReentrantLockExample1.class) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
