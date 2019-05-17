package com.faunjoe.solution.java.thread.util.concurrent.lock;

import javax.xml.stream.FactoryConfigurationError;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 可重入锁
 * synchronized 是可重入锁
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-06 22:49
 */
public class MyLock implements Lock {

    private Thread lockBy = null;

    private int lockCount = 0;

    private boolean isLocked = false;

    @Override
    public synchronized void lock() {

        Thread currentThread = Thread.currentThread();

        while (isLocked && currentThread != lockBy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isLocked = true;
        lockBy = currentThread;
        lockCount++;
    }

    @Override
    public synchronized void unlock() {
        if (lockBy == Thread.currentThread()) {
            if (lockCount > 0) {
                lockCount--;

                if (lockCount == 0) {
                    notify();
                    isLocked = false;
                }
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
