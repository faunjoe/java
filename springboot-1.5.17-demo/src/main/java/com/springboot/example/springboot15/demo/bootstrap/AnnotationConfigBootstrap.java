package com.springboot.example.springboot15.demo.bootstrap;

import com.springboot.example.springboot15.demo.config.UserConfiguration;
import com.springboot.example.springboot15.demo.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-24 14:40
 */
public class AnnotationConfigBootstrap {

    public static void main(String[] args){
        // 构建一个Spring Application 上下文
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        // 需要注册一个UserConfiguration的Bean
        applicationContext.register(UserConfiguration.class);
        applicationContext.refresh();


        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }
}
