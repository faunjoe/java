package com.faunjoe.solution.java.designpattern.singleton;

/**
 * 优雅的方式，推荐使用。
 * 这种方式既能保证懒加载，又能保证线程安全，还能保证效率特别高，不加锁。
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-28 23:35
 */
public class SingletonObject6 {

    private SingletonObject6() {
    }

    // jvm 特性 静态 使用时只加载一次。
    private static class InstanceHolder {
        private final static SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance(){
        return InstanceHolder.instance;
    }
}

