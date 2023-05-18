package com.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建一个 RoleInterceptor 对象，并将其注册到拦截器链中
        registry.addInterceptor(new TeacherInterceptor())
                .addPathPatterns("/teacher/**")
                .excludePathPatterns("/teacher/login");
        registry.addInterceptor(new StudentInterceptor())
                .addPathPatterns("/student/**")
                .excludePathPatterns("/student/login");
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/Admin/**")
                .excludePathPatterns("/Admin/login");
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**");


    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:63342/*","http://localhost:8080/*")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }

}

