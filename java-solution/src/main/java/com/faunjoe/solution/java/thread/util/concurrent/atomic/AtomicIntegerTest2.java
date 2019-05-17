package com.faunjoe.solution.java.thread.util.concurrent.atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-02 23:14
 */
public class AtomicIntegerTest2 {

    final static AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int v = value.getAndIncrement();

                    System.out.println(Thread.currentThread().getName() + ":" + v);

                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int v = value.getAndAdd(10);
                    System.out.println(Thread.currentThread().getName() + ":" + v);
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int v = value.getAndSet(0);
                    System.out.println(Thread.currentThread().getName() + ":" + v);
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}
