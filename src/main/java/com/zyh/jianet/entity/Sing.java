package com.zyh.jianet.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Sing {
    // TODO: 2023/10/25 修改字段
    private Integer id;
    private Integer userId;
    private Integer spaceId;
    private Integer appointment;
    private String content;
    private String img;
    private Integer status;
    private Date createTime;
}
