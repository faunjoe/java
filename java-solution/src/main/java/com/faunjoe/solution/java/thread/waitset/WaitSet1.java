package com.faunjoe.solution.java.thread.waitset;


import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-29 00:37
 */
public class WaitSet1 {

    private static final Object LOCK = new Object();

    /**
     * 1.所有的对象都会有一个wati set,用来存放调用了该对象wait方法之后进入block状态线程
     * 2.线程被notify之后，不一定立即得到执行，必须要获得锁。
     * 3.线程从wait set 中被唤醒顺序不一定是FIFO。
     * 4.线程被唤醒后,必须重新获取锁。
     *
     * @param args
     */
    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                work();
            }
        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (LOCK){
            // 唤醒 LOCK 锁
            LOCK.notify();
        }
    }

    private static void work(){
        synchronized (LOCK){

            System.out.println("Begin ......");

            try {
                System.out.println("Thread will coming");
                LOCK.wait();
                //唤醒LOCK，需要继续强锁，往下执行。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread will out.");
        }
    }
}
