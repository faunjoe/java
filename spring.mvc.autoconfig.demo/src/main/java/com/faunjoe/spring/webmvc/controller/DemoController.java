package com.faunjoe.spring.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-11-26 15:39
 */

@RestController
public class DemoController {

    //有可能helloWorld Bean获取不到
    @Autowired(required = false)
    @Qualifier("helloWorld")
    private String helloWorld;

    @GetMapping("/")
    public String index() {
        //return "Spring Web MVC 自动装配！";

        return helloWorld;
    }
}
