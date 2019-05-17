package com.faunjoe.solution.java.thread.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-27 02:01
 */
public class SemaphoreExample4 {

    public static void main(String[] args) throws InterruptedException {

        final Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread() {
            @Override
            public void run() {

                try {
                    // 不可中断。
                    semaphore.acquireUninterruptibly();
                } finally {
                    semaphore.release();
                }
                System.out.println("T1 finished.");
            }
        };

        TimeUnit.MILLISECONDS.sleep(50);
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {

                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
                System.out.println("T2 finished.");
            }
        };

        t2.start();

        TimeUnit.MILLISECONDS.sleep(50);
        t1.interrupt();
    }

}
