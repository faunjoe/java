package com.faunjoe.demo.springbootstart.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-29 12:36
 */
@Component
public class PrintListener implements ApplicationListener<MsgEvent> {
    @Override
    public void onApplicationEvent(MsgEvent event) {
        System.out.println("调用MsgEvent的print方法输出其内容:");
        event.print();
    }
}
