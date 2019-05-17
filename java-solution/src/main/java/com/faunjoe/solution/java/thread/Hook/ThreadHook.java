package com.faunjoe.solution.java.thread.Hook;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-24 23:13
 */
public class ThreadHook {

    // kill pid 有用
    // kill -9 pid 没有用，强杀。
    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The application will be exit.");
            notifyAndRelease();
        }));

        int i = 0;
        while (true) {
            try {
                Thread.sleep(1_000L);
                System.out.println("I am working...");
            } catch (Exception e) {
                //ignore
            }
            i++;
            if (i > 20) {
                throw new RuntimeException("error");
            }
        }
    }

    private static void notifyAndRelease() {
        System.out.println("nofity to the admin.");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println("will release resource(socket,file,connection.)");
    }
}
