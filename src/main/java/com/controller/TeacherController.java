package com.controller;

import com.Data.Teacher;
import com.Request.LoginRequest;
import com.RuanxieApplication;
import com.service.TeacherLogin;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@RestController
@EnableSwagger2
@CrossOrigin
public class TeacherController{
    @ApiOperation(value = "所有人", notes = "老师登录")
    @PostMapping("/teacher/login")
    public ResponseEntity<String> login(@ApiParam(value = "老师ID或者老师Email或者老师电话以及密码", required = true) @RequestBody() LoginRequest request,
                                        HttpServletResponse response) throws IOException {
        TeacherLogin teacherLogin =new TeacherLogin();
        Teacher teacher = teacherLogin.Login(request.getId(),request.getPassword());
        if ( teacher != null) {
            // 登录成功
            RuanxieApplication.maplog.setMap("ID",teacher.getTeacherID());
            RuanxieApplication.maplog.setMap("userType","teacher");
            return ResponseEntity.ok("登录成功");
        } else {
            // 登录失败
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登录失败");
        }
    }
}
