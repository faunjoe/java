package com.faunjoe.solution.java.designpattern.singleton;

/**
 * 懒加载，多线程下安全，解决了性能问题。
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-28 23:35
 */
public class SingletonObject5 {

    // 解决单例4中的问题 加volatile
    // volatile 不能保证原子性，但是可以保证线程间的可见性,有序性。
    // 在C++中 volatile 告诉编译器不要自作多情的给我优化。happen before
    private static volatile SingletonObject5 instance;

    // 构造函数如果依赖外部引用处理一些东西，会出现重新排序，导致没有加载完。
    private SingletonObject5() {

    }

    // double check
    public static SingletonObject5 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject5.class) {
                if (null == instance) {
                    instance = new SingletonObject5();
                }
            }
        }

        return instance;
    }
}
