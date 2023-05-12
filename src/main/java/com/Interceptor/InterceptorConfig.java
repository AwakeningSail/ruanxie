package com.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建一个 RoleInterceptor 对象，并将其注册到拦截器链中
        registry.addInterceptor(new TeacherInterceptor())
                .addPathPatterns("/teacher/*");
        registry.addInterceptor(new StudentInterceptor())
                .addPathPatterns("/student/*");
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/Admin/*");
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**");

    }

}
