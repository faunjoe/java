package com.faunjoe.solution.java.thread.util.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock需要显示地获取和释放锁,可以方便的实现公平性
 * 非阻塞的获取锁
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-06 22:03
 */
public class Sequence {

    private Lock lock = new ReentrantLock();

    private int value;

    public int getNext() {
        lock.lock();
        int a = value++;
        lock.unlock();
        return a;
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " : " + s.getNext());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " : " + s.getNext());
                }
            }
        }).start();
    }

}
