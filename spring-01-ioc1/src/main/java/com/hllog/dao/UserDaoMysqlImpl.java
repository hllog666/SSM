package com.hllog.dao;

public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("MuSQL获取用户数据");
    }
}
