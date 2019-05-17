package com.faunjoe.solution.java.thread.util.concurrent.countdownlatch;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 这是有问题的，不是等一起执行完，而且结束不了。
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-04 22:46
 */
public class CountDownLatchExample1 {

    private static Random random = new Random(System.currentTimeMillis());

    private static Executor executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        final int[] data = query();

        for (int i = 0; i < data.length; i++) {
            executor.execute(new SimpleRunnable(data, i));
        }

        System.out.println("all of work finish done.");
    }

    static class SimpleRunnable implements Runnable {

        private final int[] data;

        private final int index;

        public SimpleRunnable(int[] data, int index) {
            this.data = data;
            this.index = index;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int value = data[index];
            if (value % 2 == 0) {
                data[index] = value * 2;
            } else {
                data[index] = value * 10;
            }

            System.out.println(Thread.currentThread().getName() + "finished.");
        }
    }

    private static int[] query() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }
}
