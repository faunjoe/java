package com.faunjoe.solution.java.thread.interrupt;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-15 16:09
 */
public class ThreadInterrupt {

    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // t 线程睡眠
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName()+"收到打断信号.");
                        e.printStackTrace();
                    }
                }
            }
        };

        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"收到打断信号.");
            e.printStackTrace();
        }
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
