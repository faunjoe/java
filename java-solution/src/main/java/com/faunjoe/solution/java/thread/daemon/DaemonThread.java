package com.faunjoe.solution.java.thread.daemon;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-06 13:51
 */
public class DaemonThread extends Thread {

    public DaemonThread(String name){
        super(name);
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + "线程执行了...");
        }
    }
}
