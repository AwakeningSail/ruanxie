package com.controller;

import com.Request.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@EnableSwagger2
public class MyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @PostMapping(value = "/test")
    public void handleFormUrlEncoded(@RequestBody LoginRequest request, HttpServletResponse response) {
        LOGGER.info("Received form data: {}", request);
    }
    @RestController
    @RequestMapping("/login")
    public class UserController {
        @GetMapping
        public String getUsers() {
            return "Hello Spring Security";
        }
    }

}
