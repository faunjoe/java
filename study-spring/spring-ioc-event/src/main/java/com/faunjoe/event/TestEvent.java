package com.faunjoe.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/16 12:15
 */
@Configuration
@ComponentScan
public class TestEvent {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TestEvent.class);
        UserService us=(UserService)ctx.getBean("userService");
        us.registerUser("zghw", "13699120345");
    }
}