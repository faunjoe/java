package com.faunjoe.solution.java.designpattern.singleton;

/**
 * 懒加载，多线程下安全，缺点是串行化,对性能不好。
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-28 23:35
 */
public class SingletonObject3 {

    private static SingletonObject3 instance ;

    private SingletonObject3() {

    }

    public synchronized static SingletonObject3 getInstance() {
        if(null == instance){
            instance = new SingletonObject3();
        }
        return instance;
    }
}
