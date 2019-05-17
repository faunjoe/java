package com.faunjoe.solution.java.thread.util.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-27 12:44
 */
public class ReadWriteLockExample {

    private final static ReentrantReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock(true);

    private final static Lock readLock = READ_WRITE_LOCK.readLock();

    private final static Lock writeLock = READ_WRITE_LOCK.writeLock();

    private final static List<Long> data = new ArrayList<>();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> write());
        t1.start();

        Thread t2 = new Thread(ReadWriteLockExample::read);
        t2.start();
    }

    private static void write() {
        for (; ; ) {
            try {
                writeLock.lock();
                data.add(System.currentTimeMillis());
            } finally {
                writeLock.unlock();
            }
        }
    }

    private static void read() {
        for (; ; ) {
            try {
                readLock.lock();
                data.forEach(System.out::println);
                System.out.println(Thread.currentThread().getName() + "===================");
            } finally {
                readLock.unlock();
            }
        }
    }
}
