package com.faunjoe.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/16 12:14
 */
@Component
public class SendMessageListenter implements ApplicationListener<SendMessageEvent> {

    /**
     * 监听事件SendMessage，当有事件发生则调用该方法
     */
    public void onApplicationEvent(SendMessageEvent event) {
        Message message = event.getMessage();
        String msg=message.getMessage();
        String phone = message.getPhone();
        try {
            System.out.println("开始向手机"+phone+"发送短信，短信内容为："+msg);
            Thread.sleep(1000);
            System.out.println("发送短信成功！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
