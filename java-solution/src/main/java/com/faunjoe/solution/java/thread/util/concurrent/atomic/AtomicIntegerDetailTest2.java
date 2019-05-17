package com.faunjoe.solution.java.thread.util.concurrent.atomic;

import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-03 22:49
 */
public class AtomicIntegerDetailTest2 {

    private final static CompareAndSetLock lock = new CompareAndSetLock();

    public static void main(String[] args) {

        //2.个线程，1个获得锁，另一个线程抛异常。
        IntStream.range(0, 5).forEach(i -> new Thread() {
            @Override
            public void run() {
                try {
                    doSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (GetLockException e) {
                    e.printStackTrace();
                }
            }
        }.start());
    }

    private static void doSomething() throws InterruptedException, GetLockException {
        try {
            lock.tryLock();
            System.out.println(Thread.currentThread().getName() + " get the lock");
            Thread.sleep(10000);
        } finally {
            // unLock 里面判断了是否是当前线程。否则就会出现问题。
            lock.unLock();
        }
    }
}
