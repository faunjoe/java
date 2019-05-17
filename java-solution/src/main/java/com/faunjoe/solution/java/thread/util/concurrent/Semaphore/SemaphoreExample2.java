package com.faunjoe.solution.java.thread.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-27 02:01
 */
public class SemaphoreExample2 {

    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < 2; i++)
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " in");

                    try {
                        semaphore.acquire();
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
    }

}
