package com.faunjoe.solution.java.designpattern.observersubject;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-30 22:53
 */
public class ObserverClient {
    public static void main(String[] args){
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);
        System.out.println("=================");
        subject.setState(10);

        System.out.println("=================");
        subject.setState(10);

        System.out.println("=================");
        subject.setState(15);
    }
}
