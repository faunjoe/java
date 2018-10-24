package com.faunjoe.rebuild;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/26 15:24
 */
public class HummerH1 extends HummerModel {
    /**
     * 判断标记
     */
    private boolean alarmFlag = true;

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

    /**
     * 覆写isAlarm方法，返回判断标记
     *
     * @return
     */
    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    /**
     * 设置判断标记
     *
     * @param isAlarm
     */
    public void setAlarmFlag(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }
}
