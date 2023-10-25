package com.zyh.jianet.contorller;

import com.zyh.jianet.entity.Status;
import com.zyh.jianet.entity.Student;
import com.zyh.jianet.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("student")
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/getStudentByNumber")
    @ResponseBody
    public Status<Student> getStudentByNumber(@RequestHeader("token") String token){
        return studentService.selectStudentByNumber(token);
    }
}
