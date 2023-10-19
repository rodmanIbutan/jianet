package com.zyh.jianet.entity;

import lombok.Data;

@Data
public class Student {
    //id,name,number,password,class_code,score
    private Integer id;
    private String name;
    private String number;
    private String password;
    private Integer class_code;
    private Integer score;

}
