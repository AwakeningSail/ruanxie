package com.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class StudentInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 判断当前用户是否为学生，如果不是则返回错误信息或跳转到错误页面
        // 例如：
         String userType = (String) request.getSession().getAttribute("userType");
         if (userType == null || !"student".equals(userType)) {
             response.sendError(HttpServletResponse.SC_FORBIDDEN, "无权访问该资源");
             return false;
         }
        return true;
    }
}
