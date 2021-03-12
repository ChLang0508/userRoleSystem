package com.chlang.user_role_system.security.customerFiter;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 重写登录拦截器,用来支持json提交
 */

public class CustomerUsernamePasswordAuthenticationFilter extends
        UsernamePasswordAuthenticationFilter {

    private boolean postOnly = true;

    public CustomerUsernamePasswordAuthenticationFilter() {
        super();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String username = "";
        String password = "";

        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String str = "";
            StringBuilder wholeStr = new StringBuilder();
            while ((str = reader.readLine()) != null) {//一行一行的读取body体里面的内容；
                wholeStr.append(str);
            }
            JSONObject t = JSONObject.parseObject(wholeStr.toString());//转化成json对象
            username = (String) t.get("userName");
            password = (String) t.get("password");
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (username == null || password == null) {
            username = obtainUsername(request);
            password = obtainPassword(request);
        }

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
