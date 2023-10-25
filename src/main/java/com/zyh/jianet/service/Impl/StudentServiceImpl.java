package com.zyh.jianet.service.Impl;

import com.zyh.jianet.entity.Status;
import com.zyh.jianet.entity.Student;
import com.zyh.jianet.mapper.StudentMapper;
import com.zyh.jianet.service.StudentService;
import com.zyh.jianet.until.JwtUntil;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
    @Override
    public Status<Student> selectStudentByNumber(String token) {
        String number = JwtUntil.parseJWT(token).get("number", String.class);
        return new Status<Student>(true,"查询成功",studentMapper.selectStudentByNumber(number));
    }
}
