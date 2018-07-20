package com.kaikeba.impl;

import com.kaikeba.service.BaseService;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 11:52
 */
public class Dog implements BaseService {
    public void eat() {
        System.out.println("啃骨头");
    }

    public void wc() {
        System.out.println("三腿立");
    }
}
