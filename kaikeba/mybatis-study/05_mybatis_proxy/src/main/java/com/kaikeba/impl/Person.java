package com.kaikeba.impl;

import com.kaikeba.service.BaseService;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 11:52
 */
public class Person implements BaseService {
    public void eat() {
        // 主要业务，代理模式要求开发人员只关心主要业务
        System.out.println("使用筷子吃饭....");
    }

    public void wc() {
        System.out.println("测试地球重力是否存在");
    }
}
