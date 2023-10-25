package com.zyh.jianet.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Appointment {
    private int id;
    private int spaceId;
    private String userNumber;
    private String bookingDate;
    private int bookingTime;
    private Integer status;
    private Date createTime;
}
