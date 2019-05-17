package com.faunjoe.solution.java.designpattern.observersubject;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-30 22:51
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Hexa String:" + Integer.toBinaryString(subject.getState()));
    }
}
