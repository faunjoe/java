package com.faunjoe.solution.java.thread.util.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-27 00:29
 */
public class CyclicBarrierExample4 {

    public static void main(String[] args) {

        //回调方式通知运行结束。
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("T1 finished.");
                    cyclicBarrier.await();
                    System.out.println("T1 The other thread finished too.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("T2 finished.");
                    cyclicBarrier.await();
                    System.out.println("T2 The other thread finished too.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            TimeUnit.SECONDS.sleep(4);

            System.out.println(cyclicBarrier.getNumberWaiting());
            System.out.println(cyclicBarrier.getParties());
            System.out.println(cyclicBarrier.isBroken());
            TimeUnit.SECONDS.sleep(2);
            cyclicBarrier.reset();

            System.out.println(cyclicBarrier.getNumberWaiting());
            System.out.println(cyclicBarrier.getParties());
            System.out.println(cyclicBarrier.isBroken());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
