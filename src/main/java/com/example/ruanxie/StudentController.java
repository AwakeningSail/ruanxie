package com.example.ruanxie;

import com.Data.Student;
import com.service.StudentLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.service.TeacherLogin;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@EnableSwagger2
public class StudentController {
    @PostMapping("/students/login")
    public ResponseEntity<String> login(@RequestParam("ID") String ID, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        StudentLogin studentLogin =new StudentLogin();
        Student student = studentLogin.Login(ID,password);
        if ( student != null) {
            // 登录成功
            response.addCookie(new Cookie("studentId", student.getStudentID()));
            response.addCookie(new Cookie("userType", "student"));
            return ResponseEntity.ok("登录成功");
        } else {
            // 登录失败
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("登录失败");
        }
    }
}
