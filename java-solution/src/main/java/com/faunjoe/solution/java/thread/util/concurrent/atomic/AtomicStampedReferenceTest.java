package com.faunjoe.solution.java.thread.util.concurrent.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决CAS带来的ABA问题。
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-04 00:39
 */
public class AtomicStampedReferenceTest {

    private static AtomicStampedReference<Integer> atomicRef = new AtomicStampedReference<>(100, 0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    boolean success = atomicRef.compareAndSet(100, 101, atomicRef.getStamp(), atomicRef.getStamp() + 1);
                    System.out.println(success);

                    boolean stampSuccess = atomicRef.compareAndSet(101, 100, atomicRef.getStamp(), atomicRef.getStamp() + 1);
                    System.out.println(stampSuccess);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int stamp = atomicRef.getStamp();
                    System.out.println("Before sleep:stamp=" + stamp);
                    TimeUnit.SECONDS.sleep(2);
                    boolean success = atomicRef.compareAndSet(100, 101, stamp, stamp + 1);
                    System.out.println(success);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
