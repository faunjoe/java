package com.faunjoe;

import com.faunjoe.service.UserServiceImpl;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/23 15:11
 */
public class TestMain {
    public static void main(String[] args) {
        ClassPathXMLApplicationContext context =
                new ClassPathXMLApplicationContext("configAnnotation.xml");

        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        userService.show();
    }
}
