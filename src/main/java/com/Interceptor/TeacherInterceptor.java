package com.Interceptor;

import com.RuanxieApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class TeacherInterceptor implements RoleInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 判断当前用户是否为老师，如果不是则返回错误信息或跳转到错误页面
        // 例如：
        System.out.println("TeacherInterceptor Method:"+request.getMethod());
        if(request.getMethod().equals("OPTIONS")){
            System.out.println("success");
            return true;
        }
         String userType =  RuanxieApplication.maplog.FinduserType();
         if (userType == null || !"teacher".equals(userType)) {
             response.sendError(HttpServletResponse.SC_FORBIDDEN, "无权访问该资源");
             return false;
         }
        return true;
    }
}

