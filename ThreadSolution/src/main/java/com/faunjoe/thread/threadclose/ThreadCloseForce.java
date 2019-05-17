package com.faunjoe.thread.threadclose;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-16 13:40
 */
public class ThreadCloseForce {


    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
            while (true) {

            }
        });
        service.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
