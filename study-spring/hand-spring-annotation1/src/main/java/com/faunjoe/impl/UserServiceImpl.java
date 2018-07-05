package com.faunjoe.impl;


import com.faunjoe.annotation.ExtResource;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/5 13:30
 */
public class UserServiceImpl {

    public UserDaoImpl userDao;
    public User1DaoImpl user1Dao;

    /**
     * 字段上的注解,可以配置name属性
     */
    @ExtResource
    public User2DaoImpl user2Dao;


    /**
     * set方法上的注解，带有name属性
     * @param userDao
     */
    @ExtResource(name = "userDao")
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }


    /**
     * set方法上的注解，没有配置name属性
     * @param user1Dao
     */
    @ExtResource
    public void setUser1Dao(User1DaoImpl user1Dao) {
        this.user1Dao = user1Dao;
    }

    public void show() {
        userDao.show();
        user1Dao.show();
        user2Dao.show();
        System.out.println("这里是Service方法........");
    }

}
