package com.Interceptor;

import com.RuanxieApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class StudentInterceptor  implements RoleInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 判断当前用户是否为学生，如果不是则返回错误信息或跳转到错误页面
        // 例如：
        System.out.println("StudentInterceptor Method:"+request.getMethod());
        if(request.getMethod().equals("OPTIONS")){
            System.out.println("success");
            return true;
        }
        System.out.println("----------------------------------------------");
         String userType =  RuanxieApplication.maplog.FinduserType();
         System.out.println("userType :"+userType);

         if (userType == null || !"student".equals(userType)) {
             response.sendError(HttpServletResponse.SC_FORBIDDEN, "无权访问该资源");
             return false;
         }
        return true;
    }
}
