package com.faunjoe.solution.java.thread.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 11:46
 */
public class ThreadLocalSimulatorTest<T> {

    private final static ThreadLocalSimulator<String> THREAD_LOCAL = new ThreadLocalSimulator<>();

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            THREAD_LOCAL.set("Thread-T1");

            try {
                Thread.sleep(RANDOM.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " " + THREAD_LOCAL.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            THREAD_LOCAL.set("Thread-T2");

            try {
                Thread.sleep(RANDOM.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " " + THREAD_LOCAL.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("=================");
        System.out.println(Thread.currentThread().getName() + " " + THREAD_LOCAL.get());
    }
}
