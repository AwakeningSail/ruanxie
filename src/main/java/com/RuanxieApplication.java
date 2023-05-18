package com;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class RuanxieApplication {
    public static Maplog maplog;
    public static void main(String[] args) {
        SpringApplication.run(RuanxieApplication.class, args);
        maplog=new Maplog();
    }

}
