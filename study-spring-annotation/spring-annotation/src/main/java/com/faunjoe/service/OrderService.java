package com.faunjoe.service;

import com.faunjoe.dao.OrderDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 23:02
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    public void print(){
        System.out.println(orderDao);
    }

    @Override
    public String toString() {
        return "OrderService [orderDao=" + orderDao + "]";
    }
}
