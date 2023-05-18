package com.Interceptor;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Logger;

@Configuration
public class MyInterceptor implements HandlerInterceptor {

    private static String name = MyInterceptor.class.getName();
    private static Logger log = Logger.getLogger(name);
    @Override

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Expose-Headers", "content-disposition");
        response.setHeader("Content-Type","application/json;charset=UTF-8, text/javascript, */*");
        System.out.println("MyInterceptor doing");
    }
   /* @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getHeader("Content-Type"));
        System.out.println("执行了BootInterceptor的preHandle方法");

        // 根据请求类型获取 入参
        String method = request.getMethod();
        if ("GET".equalsIgnoreCase(method)) {
            Map<String, String[]> parameterMap = request.getParameterMap();
        } else {
            //获取请求body
            byte[] bodyBytes = StreamUtils.copyToByteArray(request.getInputStream());
            String body = new String(bodyBytes, request.getCharacterEncoding());
            log.info("请求体:"+body);
        }
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("执行了BootInterceptor的afterCompletion方法");


    }*/
}
