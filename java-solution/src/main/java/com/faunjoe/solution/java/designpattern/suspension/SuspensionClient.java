package com.faunjoe.solution.java.designpattern.suspension;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 02:08
 */
public class SuspensionClient {

    public static void main(String[] args) {
        final RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "Faunjoe").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
        try {
            Thread.sleep(15000L);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }

        serverThread.close();
    }
}
