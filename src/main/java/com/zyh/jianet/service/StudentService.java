package com.zyh.jianet.service;

import com.zyh.jianet.entity.Status;
import com.zyh.jianet.entity.Student;
import org.springframework.stereotype.Service;


public interface StudentService {
    Status<Student> selectStudentByNumber(String token);
}
