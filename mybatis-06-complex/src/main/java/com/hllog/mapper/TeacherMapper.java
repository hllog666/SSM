package com.hllog.mapper;

import com.hllog.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    /**
     * where id=#{tid}其中的tid由@Param("tid")绑定
     *
     * @param id
     * @return
     */
    @Select("select * from teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);
}
