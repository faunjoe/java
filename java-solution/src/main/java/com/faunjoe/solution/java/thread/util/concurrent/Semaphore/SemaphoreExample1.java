package com.faunjoe.solution.java.thread.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-27 02:01
 */
public class SemaphoreExample1 {

    public static void main(String[] args) {
        final SemaphoreLock lock = new SemaphoreLock();

        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is Running");
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + " get the #SemaphoreLock");
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                    System.out.println(Thread.currentThread().getName() + " released #SemaphoreLock");
                }
            }.start();
        }
    }

    static class SemaphoreLock {

        private final Semaphore semaphore = new Semaphore(1);

        public void lock() throws InterruptedException {
            semaphore.acquire();
        }

        public void unlock() {
            semaphore.release();
        }
    }
}
