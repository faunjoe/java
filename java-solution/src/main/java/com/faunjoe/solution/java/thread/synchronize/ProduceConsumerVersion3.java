package com.faunjoe.solution.java.thread.synchronize;

import java.util.stream.Stream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-19 22:45
 */
public class ProduceConsumerVersion3 {

    private int i = 1;

    private final Object LOCK = new Object();

    private volatile boolean isProduct = false;

    private void product() {
        synchronized (LOCK) {
            if (isProduct) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("P->" + (i++));
                isProduct = true;
                LOCK.notify();
            }

        }
    }

    private void consume() {
        synchronized (LOCK) {
            if (isProduct) {
                System.out.println("C->" + i);
                LOCK.notify();
                isProduct = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion3 pc = new ProduceConsumerVersion3();

        Stream.of("P1", "p2").forEach(n -> {
            new Thread("p") {
                @Override
                public void run() {
                    while (true)
                        pc.product();
                }
            }.start();
        });

        Stream.of("P1", "p2").forEach(n -> {

            new Thread("c") {
                @Override
                public void run() {
                    while (true)
                        pc.consume();
                }
            }.start();
        });
    }
}

// 全都wait

// jps
// jstack
