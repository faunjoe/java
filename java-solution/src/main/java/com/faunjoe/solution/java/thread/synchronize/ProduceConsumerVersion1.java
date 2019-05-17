package com.faunjoe.solution.java.thread.synchronize;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-19 22:45
 */
public class ProduceConsumerVersion1 {

    private int i = 1;

    private final Object LOCK = new Object();

    private void product() {
        synchronized (LOCK) {
            System.out.println("P->" + (i++));
        }
    }

    private void consume() {
        synchronized (LOCK) {
            System.out.println("P->" + (i++));
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion1 pc = new ProduceConsumerVersion1();

        new Thread("p") {
            @Override
            public void run() {
                while (true)
                    pc.product();
            }
        }.start();

        new Thread("c") {
            @Override
            public void run() {
                while (true)
                    pc.consume();
            }
        }.start();
    }
}
