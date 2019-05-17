package com.faunjoe.solution.java.designpattern.readwritelock;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-31 10:46
 */
public class ReaderWorker extends Thread {
    private final SharedData data;

    public ReaderWorker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads "+ String.valueOf(readBuf));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
