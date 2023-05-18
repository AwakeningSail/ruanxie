package com.Interceptor;

import com.RuanxieApplication;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface RoleInterceptor extends HandlerInterceptor {
     default String FinduserType(){
//        Cookie[] cookies = request.getCookies();
//        for(Cookie cookie : cookies)if(cookie.getName().equals("userType")){
//            return cookie.getValue();
//        }
//        return null;

         return RuanxieApplication.maplog.FinduserType();
    }

}
