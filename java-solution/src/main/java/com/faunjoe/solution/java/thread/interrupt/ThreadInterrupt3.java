package com.faunjoe.solution.java.thread.interrupt;


/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-15 16:09
 */
public class ThreadInterrupt3 {


    public static void main(String[] args) {

        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("Thread t");
                }
            }
        };

        t.start();

        Thread main = Thread.currentThread();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 因为是join  阻塞的是main线程。 join和wait\sleep不一样。
                main.interrupt();

                System.out.println("interrupt");
            }
        };

        t2.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
