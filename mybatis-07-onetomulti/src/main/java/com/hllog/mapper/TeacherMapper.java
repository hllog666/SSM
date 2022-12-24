package com.hllog.mapper;

import com.hllog.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher();

    Teacher getTeacher2(@Param("tid") int id);

    Teacher getTeacher3(@Param("tid") int id);
}
