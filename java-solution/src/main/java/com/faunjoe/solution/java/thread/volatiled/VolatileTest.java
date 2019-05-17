package com.faunjoe.solution.java.thread.volatiled;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-30 00:56
 */
public class VolatileTest {

    // volatile 不能保证原子性，但是能保证可见性，有序性
    private volatile static int INIT_VALUE = 0;

    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("READER the value  to [%d] \n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                System.out.printf("Update the value  to [%d] \n", ++INIT_VALUE);
                localValue = INIT_VALUE;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "UPDATES").start();
    }
}
