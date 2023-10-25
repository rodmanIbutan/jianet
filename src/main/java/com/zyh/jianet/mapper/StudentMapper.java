package com.zyh.jianet.mapper;

import com.zyh.jianet.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
    Student selectStudentByNumber(@Param("number") String number);
}
