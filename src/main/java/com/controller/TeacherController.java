package com.controller;

import com.Data.Teacher;
import com.Data1.JsonFactory;
import com.Request.LoginRequest;
import com.Request.objectRequest;
import com.RuanxieApplication;
import com.service.TeacherService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@RestController
@EnableSwagger2
@CrossOrigin
public class TeacherController{
    JsonFactory jsonFactory;
    @ApiOperation(value = "所有人", notes = "老师登录")
    @PostMapping("/teacher/login")
    @ApiImplicitParam
    public ResponseEntity<String> login(@ApiParam(value = "老师ID或者老师Email或者老师电话以及密码", required = true) @RequestBody() LoginRequest request,
                                        HttpServletResponse response) throws IOException {
        TeacherService teacherLogin =new TeacherService();
        Teacher teacher = teacherLogin.Login(request.getId(),request.getPassword());
        jsonFactory =new JsonFactory();
        if ( teacher != null) {
            // 登录成功
            RuanxieApplication.maplog.setMap("ID",teacher.getTeacherID());
            RuanxieApplication.maplog.setMap("userType","teacher");
            return ResponseEntity.ok(jsonFactory.toJsonString(new objectRequest("1","登录成功")));
        } else {
            // 登录失败
            return ResponseEntity.ok(jsonFactory.toJsonString(new objectRequest("2","登录失败")));
        }
    }
}
