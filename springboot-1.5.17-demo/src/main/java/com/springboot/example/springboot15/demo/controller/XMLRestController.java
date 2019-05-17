package com.springboot.example.springboot15.demo.controller;

import com.springboot.example.springboot15.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/11/19 15:58
 */

@RestController
@RequestMapping("/xml")
public class XMLRestController {


    @Autowired
    @Qualifier("currentUser")
    private User user;

    @GetMapping(path = "/user",
            produces = MediaType.APPLICATION_XML_VALUE)
    public User user() {


        return user;
    }


}
