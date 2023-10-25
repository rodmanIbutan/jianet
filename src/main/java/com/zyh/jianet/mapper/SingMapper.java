package com.zyh.jianet.mapper;

import com.zyh.jianet.entity.Sing;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SingMapper {
    Sing selectSingById(Integer id);
}
