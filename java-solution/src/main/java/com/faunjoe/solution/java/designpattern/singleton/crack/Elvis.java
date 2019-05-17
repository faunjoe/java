package com.faunjoe.solution.java.designpattern.singleton.crack;

import java.time.LocalDateTime;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-03-01 17:56
 */
public class Elvis {

    private static boolean flag = false;

    private Elvis(){

    }

    private static class SingletonHolder {
        private static final Elvis INSTANCE = new Elvis();
    }

    public static Elvis getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void doSomethingElse(){
        System.out.println(LocalDateTime.now().toString());
    }
}
