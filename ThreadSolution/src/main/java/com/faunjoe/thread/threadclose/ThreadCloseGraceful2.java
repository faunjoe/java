package com.faunjoe.thread.threadclose;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-16 13:40
 */
public class ThreadCloseGraceful2 {

    private static class Worker extends Thread {


        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    break;
                }
            }

            System.out.println("ok!");
        }

    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt();
    }
}
