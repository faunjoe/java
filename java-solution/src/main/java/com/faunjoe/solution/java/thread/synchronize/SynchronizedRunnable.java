package com.faunjoe.solution.java.thread.synchronize;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-16 16:01
 */
public class SynchronizedRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 500;

    @Override
    public void run() {
        while (true) {
            if (ticket())
                break;
        }
    }

    // this lock
    private synchronized boolean ticket() {
        if (index > MAX) {
            return true;
        }

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
        return false;
    }

    // this lock
    private boolean ticket1() {
        synchronized (this) {
            if (index > MAX) {
                return true;
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
            return false;
        }
    }

    public static void main(String[] args) {
        SynchronizedRunnable r1 = new SynchronizedRunnable();

        Thread t1 = new Thread(r1, "一号窗口");
        Thread t2 = new Thread(r1, "二号窗口");
        Thread t3 = new Thread(r1, "三号窗口");

        t1.start();
        t2.start();
        t3.start();
    }
}
