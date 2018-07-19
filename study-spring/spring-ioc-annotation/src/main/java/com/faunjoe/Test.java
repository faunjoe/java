package com.faunjoe;

import com.faunjoe.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/30 00:38
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService1 = (UserService) ctx.getBean("userService");
        //UserService userService2 = (UserService) ctx.getBean("&userService");

        System.out.println(userService1);
        //System.out.println(userService1.equals(userService2));
        userService1.save();
    }
}
