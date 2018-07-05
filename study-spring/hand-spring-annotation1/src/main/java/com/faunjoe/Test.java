package com.faunjoe;


import com.faunjoe.impl.UserServiceImpl;
import com.faunjoe.spring.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext path = new ClassPathXmlApplicationContext(
                "spring.xml");
        UserServiceImpl userService = (UserServiceImpl) path.getBean("userService");
        userService.show();
    }
}
