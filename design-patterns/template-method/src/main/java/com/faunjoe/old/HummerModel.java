package com.faunjoe.old;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/26 11:08
 * 悍马
 */
public abstract class HummerModel {

    /**
     * 发动
     */
    public abstract void start();

    /**
     * 停止
     */
    public abstract void stop();

    /**
     * 鸣笛
     */
    public abstract void alarm();

    /**
     * 轰鸣
     */
    public abstract void engineBoom();

    /**
     * 车总归要跑
     */
    public abstract void run();
}
