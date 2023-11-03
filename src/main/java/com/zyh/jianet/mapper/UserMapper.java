package com.zyh.jianet.mapper;

import com.zyh.jianet.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {
    User selectUserByNumber(@Param("number") String number);
    User upDateUserPwd(@Param("password") String passWord,@Param("number") String number);
    Integer updateToken(@Param("token") String token,@Param("number") String number);
}
