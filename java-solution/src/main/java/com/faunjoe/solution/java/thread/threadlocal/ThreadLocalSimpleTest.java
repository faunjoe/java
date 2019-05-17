package com.faunjoe.solution.java.thread.threadlocal;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 11:27
 */
public class ThreadLocalSimpleTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Faunjoe";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("faunjoe");
        Thread.sleep(1000);
        String value = threadLocal.get();
        System.out.println(value);
    }
}
