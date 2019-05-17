package com.faunjoe.solution.java.thread.synchronize.gate;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-31 00:13
 */
public class Client {

    public static void main(String[] args){

        Gate gate = new Gate();

        User bj = new User("Beijing","BeiJing",gate);
        User gz = new User("Guangzhou","GuangZhou",gate);
        User wh = new User("Wuhan","WuHan",gate);

        bj.start();
        gz.start();
        wh.start();
    }
}
