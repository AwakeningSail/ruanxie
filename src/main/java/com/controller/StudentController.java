package com.controller;

import com.Data.Student;
import com.Data1.JsonFactory;
import com.Request.LoginRequest;
import com.Request.objectRequest;
import com.RuanxieApplication;
import com.service.StudentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@RestController
@EnableSwagger2
@CrossOrigin
public class StudentController  {
    JsonFactory jsonFactory;
    Student studentlog;
    @ApiOperation(value = "所有人", notes = "学生登录")
    @PostMapping("/student/login")
    @ApiImplicitParam
    public ResponseEntity<String> login(@ApiParam(value = "学生ID或者学生Email或者学生电话以及密码", required = true) @RequestBody() LoginRequest request
            , HttpServletResponse response) throws IOException {
        StudentService studentService = new StudentService();
        Student student = studentService.Login(request.getId(), request.getPassword());
        System.out.println(student);
        jsonFactory =new JsonFactory();
        if (student != null) {
            // 登录成功
            RuanxieApplication.maplog.setMap("ID",student.getStudentID());
            RuanxieApplication.maplog.setMap("userType","student");
            if(student.getTeamID()!=-1)RuanxieApplication.maplog.setMap("TeamID",student.getTeamID());
            return ResponseEntity.ok(jsonFactory.toJsonString(new objectRequest("1","登录成功")));
        } else {
            // 登录失败
            return ResponseEntity.ok(jsonFactory.toJsonString(new objectRequest("2","登录失败")));
        }
    }

}
