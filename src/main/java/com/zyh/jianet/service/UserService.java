package com.zyh.jianet.service;

import com.zyh.jianet.entity.Status;
import com.zyh.jianet.entity.User;

public interface UserService {
    Status<User> login(User user);
}
