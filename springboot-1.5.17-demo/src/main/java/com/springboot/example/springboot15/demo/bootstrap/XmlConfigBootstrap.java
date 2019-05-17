package com.springboot.example.springboot15.demo.bootstrap;

import com.springboot.example.springboot15.demo.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-24 14:31
 */
public class XmlConfigBootstrap {

    public static void main(String[] args) {
        // 构建一个Spring Application 上下文
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext();

        applicationContext.setConfigLocations("classpath:/META-INF/spring/user-context.xml");
        applicationContext.refresh();


        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }
}
