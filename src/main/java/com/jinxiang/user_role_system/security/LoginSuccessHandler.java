package com.jinxiang.user_role_system.security;

import com.alibaba.fastjson.JSONObject;
import com.jinxiang.user_role_system.pojo.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器，用于签发token和存入redis
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {


    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String resStr = "";
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(new ResponseEntity<>(200, true, "登录成功", null));
        response.setContentType("application/json;charset=utf-8");
        resStr = jsonObject.toJSONString();

        response.getWriter().write(resStr);
    }
}
