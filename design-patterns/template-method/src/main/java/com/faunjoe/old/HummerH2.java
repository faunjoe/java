package com.faunjoe.old;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/26 11:14
 */
public class HummerH2 extends HummerModel {

    @Override
    public void start() {
        System.out.println("H2发动……");
    }

    @Override
    public void stop() {
        System.out.println("H2停止……");
    }

    @Override
    public void alarm() {
        System.out.println("H2鸣笛……");
    }

    @Override
    public void engineBoom() {
        System.out.println("H2轰鸣……");
    }

    @Override
    public void run() {
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}
