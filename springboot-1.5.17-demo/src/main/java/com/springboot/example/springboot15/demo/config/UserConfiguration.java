package com.springboot.example.springboot15.demo.config;

import com.springboot.example.springboot15.demo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-24 14:37
 */

@Configuration
public class UserConfiguration {

    @Bean(name = "user")
    public User user (){
        User user = new User();
        user.setAge(30);
        user.setFirstName("jack");
        user.setLastName("fu");
        user.setTel("13889898989");
        return user;
    }
}
