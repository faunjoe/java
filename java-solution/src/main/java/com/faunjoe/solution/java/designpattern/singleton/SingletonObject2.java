package com.faunjoe.solution.java.designpattern.singleton;

/**
 * 多线程下 有可能是非单例，不安全
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-28 23:35
 */
public class SingletonObject2 {

    private static SingletonObject2 instance ;

    private SingletonObject2() {

    }

    public static SingletonObject2 getInstance() {
        if(null == instance){
            instance = new SingletonObject2();
        }
        return instance;
    }
}
