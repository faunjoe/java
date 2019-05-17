package com.faunjoe.solution.java.thread.synchronize;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-16 17:12
 */
public class SychronizedStatic {

    //只加载一次
    static {
        synchronized (SychronizedStatic.class){
            System.out.println("static  " + Thread.currentThread().getName());

            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void m1() {
        System.out.println("m1  " + Thread.currentThread().getName());

        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void m2() {
        System.out.println("m2  " + Thread.currentThread().getName());

        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m3() {
        System.out.println("m3  " + Thread.currentThread().getName());

        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
