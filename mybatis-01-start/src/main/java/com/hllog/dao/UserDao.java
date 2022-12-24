package com.hllog.dao;

import com.hllog.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    User getUserById2(Map<String, Object> map);

    int addUser2(Map<String, Object> map);

    List<User> getUserByName(String name);
}
