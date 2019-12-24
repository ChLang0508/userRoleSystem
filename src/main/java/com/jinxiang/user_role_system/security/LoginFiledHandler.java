package com.jinxiang.user_role_system.security;

import com.alibaba.fastjson.JSONObject;
import com.jinxiang.user_role_system.pojo.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理器，用于响应错误信息
 */
public class LoginFiledHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String resStr = "";
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(new ResponseEntity<>(401, false, "登录失败，请检查账户和密码", null));
        response.setContentType("application/json;charset=utf-8");
        resStr = jsonObject.toJSONString();
        response.getWriter().write(resStr);
    }
}
