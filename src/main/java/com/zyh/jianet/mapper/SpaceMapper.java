package com.zyh.jianet.mapper;

import com.zyh.jianet.entity.Space;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpaceMapper {
    Space selectSpaceById(@Param("id") Integer id);
    List<Space> selectSpace();
}
