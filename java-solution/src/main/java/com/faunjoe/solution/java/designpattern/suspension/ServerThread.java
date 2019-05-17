package com.faunjoe.solution.java.designpattern.suspension;


import java.util.Random;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 02:02
 */
public class ServerThread extends Thread {

    private final RequestQueue queue;

    private final Random random;

    private volatile boolean close = false;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!close) {
            Request request = queue.getRequest();
            if (null == request) {
                System.out.println(" Received the empty request. ");
                continue;
            }

            System.out.println(" Server -> " + request.getValue());

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void close() {
        this.close = true;
        this.interrupt();
    }
}
