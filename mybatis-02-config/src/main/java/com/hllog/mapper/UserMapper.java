package com.hllog.mapper;

import com.hllog.pojo.User;

import java.util.List;

public interface UserMapper {
    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
