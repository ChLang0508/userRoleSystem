package com.chlang.user_role_system.security.handler;

/**
 * Created by chLang on 2019/11/16
 */

import com.alibaba.fastjson.JSONObject;
import com.chlang.user_role_system.entity.ResponseEntity;
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
        String resStr = "";
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(new ResponseEntity<>(401, false, "请登录", null));
        response.setContentType("application/json;charset=utf-8");
        resStr = jsonObject.toJSONString();
        response.getWriter().write(resStr);
    }
}
