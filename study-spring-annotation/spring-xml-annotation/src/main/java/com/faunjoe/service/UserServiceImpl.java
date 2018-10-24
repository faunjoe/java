package com.faunjoe.service;

import com.faunjoe.annotation.ZxfResource;
import com.faunjoe.dao.User1Dao;
import com.faunjoe.dao.User2Dao;
import com.faunjoe.dao.UserDao;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/23 14:20
 */
public class UserServiceImpl {

    private UserDao userDao;
    private User1Dao user1Dao;

    @ZxfResource
    private User2Dao user2Dao;

    // set方法上的注解，带有name属性
    @ZxfResource(name = "userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // set方法上的注解，没有配置name属性
    @ZxfResource
    public void setUser1Dao(User1Dao user1Dao) {
        this.user1Dao = user1Dao;
    }

    public void show() {
        userDao.show();
        user1Dao.show1();
        user2Dao.show2();
        System.out.println("这里是Service方法........");
    }
}
