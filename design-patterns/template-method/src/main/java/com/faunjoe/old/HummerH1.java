package com.faunjoe.old;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/26 11:14
 */
public class HummerH1 extends HummerModel {

    @Override
    public void start() {
        System.out.println("H1发动……");
    }

    @Override
    public void stop() {
        System.out.println("H1停止……");
    }

    @Override
    public void alarm() {
        System.out.println("H1鸣笛……");
    }

    @Override
    public void engineBoom() {
        System.out.println("H1轰鸣……");
    }

    @Override
    public void run() {
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}
