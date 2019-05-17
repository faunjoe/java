package com.faunjoe.demo.springbootstart.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-29 14:48
 */

//@Component
public class MsgEventHandle {

    //@EventListener
    public void handle(MsgEvent event){
        System.out.println("调用MsgEvent的print方法输出其内容:");
        event.print();
    }
}
