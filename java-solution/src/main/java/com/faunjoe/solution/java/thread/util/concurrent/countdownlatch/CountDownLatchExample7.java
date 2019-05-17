package com.faunjoe.solution.java.thread.util.concurrent.countdownlatch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-04 22:46
 */
public class CountDownLatchExample7 {


    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        }.start();

        // await 等1000毫秒
        latch.await(1000,TimeUnit.MILLISECONDS);
        System.out.println("=================");

    }

}
