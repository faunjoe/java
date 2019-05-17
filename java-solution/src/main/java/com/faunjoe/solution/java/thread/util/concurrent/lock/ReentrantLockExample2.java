package com.faunjoe.solution.java.thread.util.concurrent.lock;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-27 12:04
 */
public class ReentrantLockExample2 {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {

    }

    public static void testLockInterruptibly() {
        try {
            lock.lockInterruptibly();
            Optional.of("The thread-" + Thread.currentThread().getName() + " get lock and will do working.")
                    .ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void testTryLock(){
        try {
            if(lock.tryLock()){
                Optional.of("The thread-" + Thread.currentThread().getName() + " get lock and will do working.")
                        .ifPresent(System.out::println);
            }
        } finally {
            lock.unlock();
        }
    }
}
