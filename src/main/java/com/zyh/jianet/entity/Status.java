package com.zyh.jianet.entity;

import lombok.Data;

@Data
public class Status<T> {
    private int code;
    private String msg;
    private T data;
    private boolean success;
    public Status(boolean success){
        if (success){
            this.code = 200;
            this.msg = "成功";
            this.success = true;
        }else {
            this.code = 500;
            this.msg = "error";
            this.success = false;
        }
    }
    public Status(boolean success, String msg, T data){
        if (success){
            this.code = 200;
            this.msg = msg;
            this.data = data;
            this.success = true;
        }else {
            this.code = 500;
            this.msg = msg;
            this.data = data;
            this.success = false;
        }
    }
    public Status(boolean success, int code, String msg, T data){
        if (success){
            this.code = code;
            this.msg = msg;
            this.data = data;
            this.success = true;
        }else {
            this.code = code;
            this.msg = msg;
            this.data = data;
            this.success = false;
        }
    }
}
