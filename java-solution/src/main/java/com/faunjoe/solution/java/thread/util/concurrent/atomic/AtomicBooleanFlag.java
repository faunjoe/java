package com.faunjoe.solution.java.thread.util.concurrent.atomic;


import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-03 23:50
 */
public class AtomicBooleanFlag {

    // 完全代替 synchronized
    private final static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                while (flag.get()) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("I am working.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("I am finished.");
            }
        }.start();

        Thread.sleep(5000);

        flag.set(false);
    }
}
