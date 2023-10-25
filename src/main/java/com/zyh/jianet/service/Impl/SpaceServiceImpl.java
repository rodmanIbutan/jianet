package com.zyh.jianet.service.Impl;

import com.zyh.jianet.entity.Space;
import com.zyh.jianet.entity.Status;
import com.zyh.jianet.mapper.SpaceMapper;
import com.zyh.jianet.service.SpaceService;
import com.zyh.jianet.until.JwtUntil;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpaceServiceImpl implements SpaceService {
    final SpaceMapper spaceMapper;

    public SpaceServiceImpl(SpaceMapper spaceMapper) {
        this.spaceMapper = spaceMapper;
    }
    @Override
    public Status<Space> getSpaceById(Integer id) {
        return new Status<Space>(true,"查询成功",spaceMapper.selectSpaceById(id));
    }

    @Override
    public Status<List<Space>> getSpace(String token) {
        int id = JwtUntil.parseJWT(token).get("id", Integer.class);
        return new Status<List<Space>>(true,"查询成功",spaceMapper.selectSpace());
    }
}
