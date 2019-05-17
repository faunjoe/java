package com.faunjoe.solution.java.thread.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-27 02:01
 */
public class SemaphoreExample3 {

    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 2; i++)
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " in");

                    try {
                        semaphore.acquire(2);
                        System.out.println(Thread.currentThread().getName() + " Get the semaphore. ");
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                    System.out.println(Thread.currentThread().getName() + " out");
                }
            }.start();

        while (true){
            System.out.println("AP->" + semaphore.availablePermits());
            System.out.println("QL->" + semaphore.getQueueLength());
            System.out.println("==================================");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
