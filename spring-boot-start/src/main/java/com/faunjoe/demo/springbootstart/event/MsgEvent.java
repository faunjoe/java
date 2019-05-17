package com.faunjoe.demo.springbootstart.event;

import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-29 12:34
 */
public class MsgEvent extends ApplicationEvent {
    private String text;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MsgEvent(Object source) {
        super(source);
    }

    public MsgEvent(Object source, String text) {
        super(source);
        this.text = text;
    }

    public void print() {
        System.out.println("print event content:" + this.text);

        List<String> list = new ArrayList<>();

        List<String> list1 = new Vector<>();

        LinkedList
    }
}
