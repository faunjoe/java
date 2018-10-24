package com.faunjoe.controller;

import com.faunjoe.service.OrderService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 23:03
 */
@Controller
public class OrderController {


    @Inject
    private OrderService orderService;
}
