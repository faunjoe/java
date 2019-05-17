package com.faunjoe.solution.java.thread.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-03 22:57
 */
public class CompareAndSetLock {

    private final AtomicInteger value = new AtomicInteger(0);

    private Thread lockedThread;

    public void tryLock() throws GetLockException {
        boolean success = value.compareAndSet(0, 1);
        if (!success) {
            throw new GetLockException(" Get the Lock failed ");
        } else {
            lockedThread = Thread.currentThread();
        }
    }

    public void unLock() {
        if (0 == value.get()) {
            return;
        }

        if (lockedThread == Thread.currentThread()) {
            value.compareAndSet(1, 0);
        }
    }
}
