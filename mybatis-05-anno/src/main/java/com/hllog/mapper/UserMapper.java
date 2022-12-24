package com.hllog.mapper;

import com.hllog.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,password) values(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{name}, password=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);
}
