package com.zyh.jianet.contorller;

import com.zyh.jianet.entity.Status;
import com.zyh.jianet.entity.User;
import com.zyh.jianet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/login")
    @ResponseBody
    public Status<User> login (@RequestBody User user){
        return userService.login(user);
    }
    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }
}
