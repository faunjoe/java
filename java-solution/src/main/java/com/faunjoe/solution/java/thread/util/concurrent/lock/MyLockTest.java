package com.faunjoe.solution.java.thread.util.concurrent.lock;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-06 22:53
 */
public class MyLockTest {

    private MyLock lock = new MyLock();

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        c();
        lock.unlock();
    }

    public void c() {
        lock.lock();
        System.out.println("c");
        lock.unlock();
    }

    public static void main(String[] args) {

        MyLockTest test = new MyLockTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.a();
            }
        }).start();
    }
}
