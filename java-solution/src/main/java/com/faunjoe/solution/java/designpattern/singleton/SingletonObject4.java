package com.faunjoe.solution.java.designpattern.singleton;

/**
 * 懒加载，多线程下安全，解决了性能问题,有可能出现空引用的情况。
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-28 23:35
 */
public class SingletonObject4 {

    private static SingletonObject4 instance;

    // 构造函数如果依赖外部引用处理一些东西，会出现重新排序，导致没有加载完。
    private SingletonObject4() {

    }

    // double check
    public static SingletonObject4 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance) {
                    instance = new SingletonObject4();
                }
            }
        }

        return instance;
    }
}
