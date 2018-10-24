package com.faunjoe.rebuild;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/26 11:25
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
     * 加了一个判断是否需要鸣笛方法，默认返回true
     *
     * @return
     */
    protected boolean isAlarm() {
        return true;
    }

    /**
     * 车总归要跑
     */
    public final void run() {
        this.start();
        this.engineBoom();

        if (this.isAlarm()) {
            this.alarm();
        }

        this.stop();
    }
}