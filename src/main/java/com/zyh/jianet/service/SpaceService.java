package com.zyh.jianet.service;

import com.zyh.jianet.entity.Space;
import com.zyh.jianet.entity.Status;

import java.util.List;

public interface SpaceService {
    Status<Space> getSpaceById(Integer id);
    Status<List<Space>> getSpace(String token);
}
