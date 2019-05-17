package com.faunjoe.solution.java.thread.daemon;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-06 13:51
 */
public class DaemonTest {

    public static void main(String[] args) throws InterruptedException {
        DaemonThread d1 = new DaemonThread("first-thread");
        DaemonThread d2 = new DaemonThread("second-thread");
        // 守护线程  主线程执行完了，守护线程，不管它执行完，自动退出。
        d1.setDaemon(true);
        d2.setDaemon(true);
        d1.start();
        d2.start();

        Thread.sleep(2000L);
        System.out.println("main 执行完了");
    }
}
