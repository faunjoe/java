package com.springboot.example.springbootdemo.controller;


import com.springboot.example.springbootdemo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/11/19 11:26
 */

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("index")
    public User index(){
        User user = new User();
        user.setAge(18);
        user.setFirstName("go");
        user.setLastName("lang");
        user.setMobile("13888888888");
        return user;
    }
}
