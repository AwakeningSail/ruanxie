package com.example.ruanxie;

import com.Data.Student;
import com.Data.Teacher;
import com.service.TeacherLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@RestController
@EnableSwagger2
public class TeacherController {
    @PostMapping("/teacher/login")
    public ResponseEntity<String> login(@RequestParam("ID") String ID, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        TeacherLogin teacherLogin =new TeacherLogin();
        Teacher teacher = teacherLogin.Login(ID,password);
        if ( teacher != null) {
            // 登录成功
            response.addCookie(new Cookie("teacherId", teacher.getTeacherID()));
            response.addCookie(new Cookie("userType", "teacher"));
            return ResponseEntity.ok("登录成功");
        } else {
            // 登录失败
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登录失败");
        }
    }
}
