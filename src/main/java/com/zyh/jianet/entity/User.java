package com.zyh.jianet.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String number;
    private String password;
    private String avatar;
    private Integer position;
    private Integer status;
    private String jwt;
}
