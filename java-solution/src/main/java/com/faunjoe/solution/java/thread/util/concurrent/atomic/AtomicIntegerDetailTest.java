package com.faunjoe.solution.java.thread.util.concurrent.atomic;

import com.sun.tools.javadoc.Start;

import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-03 22:49
 */
public class AtomicIntegerDetailTest {

    public static void main(String[] args) {

        //2.个线程，1个获得锁，另一个线程等待它执行完，才能获得到锁。
        IntStream.range(1, 3).forEach(i -> new Thread() {
            @Override
            public void run() {
                try {
                    doSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start());
    }

    private static void doSomething() throws InterruptedException {
        synchronized (AtomicIntegerDetailTest.class) {
            System.out.println(Thread.currentThread().getName() + " get the lock");
            Thread.sleep(10000);
        }
    }
}
