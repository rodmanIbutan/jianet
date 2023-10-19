package com.zyh.jianet.service.Impl;

import com.zyh.jianet.entity.Status;
import com.zyh.jianet.entity.User;
import com.zyh.jianet.mapper.UserMapper;
import com.zyh.jianet.service.UserService;
import com.zyh.jianet.until.JwtUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public Status<User> login(User user){
        User user1 = userMapper.selectUserByNumber(user.getNumber());
        if(user1 == null){
            return new Status<>(false,"账号不存在",null);
        }
        else if (user1.getPassword().equals(user.getPassword())){
            String jwt = JwtUntil.generateJwt(user1.getId());
            user1.setJwt(jwt);
            return new Status<>(true,"登录成功",user1);
        }else {
            return new Status<>(false,"账号或者密码错误",null);
        }
    }

}
