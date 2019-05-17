package com.faunjoe.solution.java.thread.util.concurrent.countdownlatch;


import java.util.concurrent.CountDownLatch;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-04 22:46
 */
public class CountDownLatchExample5 {


    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);

        new Thread() {
            @Override
            public void run() {
                System.out.println("Do some initial working.");
                try {
                    Thread.sleep(1000);
                    latch.await();
                    System.out.println("Do other working...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("relased.");
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("asyn prepare for some data.");
                try {
                    Thread.sleep(2000);
                    System.out.println("data prepare for done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        }.start();
    }

}
