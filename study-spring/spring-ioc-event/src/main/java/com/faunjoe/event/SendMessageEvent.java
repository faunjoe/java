package com.faunjoe.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/16 12:12
 */
public class SendMessageEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    //消息对象
    private Message message;


    public SendMessageEvent(Object source, Message message) {
        super(source);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
