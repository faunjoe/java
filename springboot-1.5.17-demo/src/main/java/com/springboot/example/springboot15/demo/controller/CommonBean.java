package com.springboot.example.springboot15.demo.controller;

import com.springboot.example.springboot15.demo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/11/19 15:59
 */

@Component
public class CommonBean {

    @Bean
    public User currentUser() {
        User user = new User();
        user.setAge(18);
        user.setFirstName("aijun");
        user.setLastName("fu");
        user.setTel("13888888888");
        return user;
    }
}
