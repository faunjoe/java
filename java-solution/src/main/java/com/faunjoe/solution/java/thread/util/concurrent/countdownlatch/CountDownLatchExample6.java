package com.faunjoe.solution.java.thread.util.concurrent.countdownlatch;


import java.util.concurrent.CountDownLatch;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-04 22:46
 */
public class CountDownLatchExample6 {


    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        final Thread mainThread = Thread.currentThread();

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //latch.countDown();
                mainThread.interrupt();;
            }
        }.start();

        // 减为1 或 interrupt
        latch.await();
        System.out.println("=================");

    }

}
