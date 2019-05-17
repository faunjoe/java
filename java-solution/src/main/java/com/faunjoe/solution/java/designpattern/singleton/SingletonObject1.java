package com.faunjoe.solution.java.designpattern.singleton;

/**
 * 多线程下安全的单例模式,缺点不能懒加载
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-28 23:35
 */
public class SingletonObject1 {

    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1() {

    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}
