package com.faunjoe.impl;

import com.faunjoe.dao.UserDao;
import com.faunjoe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/30 00:40
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
    }
}
