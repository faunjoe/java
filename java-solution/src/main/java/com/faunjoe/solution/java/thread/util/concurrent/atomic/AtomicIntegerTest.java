package com.faunjoe.solution.java.thread.util.concurrent.atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-02 23:14
 */
public class AtomicIntegerTest {

    private static volatile int value = 0;

    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<Integer>());

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 500) {
                    set.add(value);
                    int tmp = value;
                    System.out.println(Thread.currentThread().getName() + ":" + tmp);
                    value += 1;
                    x++;
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 500) {
                    set.add(value);
                    int tmp = value;
                    System.out.println(Thread.currentThread().getName() + ":" + tmp);
                    value += 1;
                    x++;
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 500) {
                    set.add(value);
                    int tmp = value;
                    System.out.println(Thread.currentThread().getName() + ":" + tmp);
                    value += 1;
                    x++;
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println(set.size());
    }
}
