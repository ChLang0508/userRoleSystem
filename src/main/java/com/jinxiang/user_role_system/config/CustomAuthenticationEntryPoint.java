package com.jinxiang.user_role_system.config;

/**
 * Created by chLang on 2019/11/16
 */

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 自定义的未登录处理器
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

//    public CustomAuthenticationEntryPoint(){
//        super("/login");
//    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        String resStr = "未登录";
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(resStr);
    }
}
