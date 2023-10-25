package com.zyh.jianet.entity;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private String number;
    private int classId;
    private String className;
    private int collegeId;
    private String collegeName;
    private Integer score;
    private int bCollegeScore;
    private int cCollegeScore;
    private int status;

}
