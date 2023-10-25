package com.zyh.jianet.entity;

import lombok.Data;

@Data
public class Space {
    private int id;
    private String spaceName;
    private String collegeName;
    private int collegeId;
    private String building;
    private String addr;
}
