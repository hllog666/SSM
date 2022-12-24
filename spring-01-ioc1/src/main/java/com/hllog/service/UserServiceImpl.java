package com.hllog.service;

import com.hllog.dao.UserDao;
import com.hllog.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    /**
     * 每次想用不同的dao实现类都得修改
     */
    // private UserDao userDao = new UserDaoImpl();

    /**
     * 用户可以动态注入需要的dao实现类
     */
    private UserDao userDao;

    /**
     * 使用set注入之后，程序从主动创建对象变为被动接收对象
     * 主动权从程序员手中交到用户手中
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
