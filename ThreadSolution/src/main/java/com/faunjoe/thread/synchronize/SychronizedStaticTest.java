package com.faunjoe.thread.synchronize;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-16 17:14
 */
public class SychronizedStaticTest {

    public static void main(String[] args){

        new Thread("T1") {
            @Override
            public void run() {
                SychronizedStatic.m1();
            }
        }.start();

        new Thread("T2") {
            @Override
            public void run() {
                SychronizedStatic.m2();
            }
        }.start();
    }
}
