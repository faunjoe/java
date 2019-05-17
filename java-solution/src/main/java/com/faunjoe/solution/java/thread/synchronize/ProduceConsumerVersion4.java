package com.faunjoe.solution.java.thread.synchronize;

import java.util.stream.Stream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-19 22:45
 */
public class ProduceConsumerVersion4 {

    private int i = 0;

    private final Object LOCK = new Object();

    private volatile boolean isProduct = false;

    private void product() {
        synchronized (LOCK) {
            // 深刻理解下 while 和 if 的区别。
            while (isProduct) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println("P->" + i);
            LOCK.notifyAll();
            isProduct = true;

        }
    }

    private void consume() {
        synchronized (LOCK) {
            while (isProduct) {
                System.out.println("C->" + i);
                LOCK.notifyAll();
                isProduct = false;
            }

            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion4 pc = new ProduceConsumerVersion4();

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
