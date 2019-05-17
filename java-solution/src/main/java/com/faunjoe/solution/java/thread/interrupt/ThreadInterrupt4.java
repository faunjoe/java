package com.faunjoe.solution.java.thread.interrupt;


/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-15 16:09
 */
public class ThreadInterrupt4 extends Thread{

    public ThreadInterrupt4(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()){

            System.out.println(Thread.currentThread().getName() + "线程执行了...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "InterruptedException");
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "线程执行end.");

    }

    public static void main(String[] args)  {

        ThreadInterrupt4 t1 = new ThreadInterrupt4("t1");
        ThreadInterrupt4 t2 = new ThreadInterrupt4("t2");

        t1.start();
        t2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();


    }
}
