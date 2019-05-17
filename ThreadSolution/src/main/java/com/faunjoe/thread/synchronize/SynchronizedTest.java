package com.faunjoe.thread.synchronize;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-16 15:45
 */
public class SynchronizedTest {

    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (LOCK) {
                try {
                    Thread.sleep(100_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}
