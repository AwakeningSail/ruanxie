package com.Interceptor;

import com.RuanxieApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class AdminInterceptor implements RoleInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 判断当前用户是否为管理员，如果不是则返回错误信息或跳转到错误页面
        // 例如：
        System.out.println("AdminInterceptor Method:"+request.getMethod());
        if(request.getMethod().equals("OPTIONS")){
            System.out.println("success");
            return true;
        }
         String userType =  RuanxieApplication.maplog.FinduserType();
         if (userType == null || !"admin".equals(userType)) {
             response.sendError(HttpServletResponse.SC_FORBIDDEN, "无权访问该资源");
             return false;
         }
        return true;
    }
}
