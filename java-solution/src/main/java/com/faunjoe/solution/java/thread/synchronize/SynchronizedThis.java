package com.faunjoe.solution.java.thread.synchronize;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-16 16:16
 */
public class SynchronizedThis {

    private static class ThisLock {

        private final Object LOCK = new Object();


        public synchronized void m1() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void m2() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void m3() {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void m4() {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();

        new Thread("T1") {
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread("T2") {
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread("T3") {
            @Override
            public void run() {
                thisLock.m3();
            }
        }.start();

        new Thread("T4") {
            @Override
            public void run() {
                thisLock.m4();
            }
        }.start();
    }
}
