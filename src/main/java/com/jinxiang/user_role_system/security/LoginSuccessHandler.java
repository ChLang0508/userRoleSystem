package com.jinxiang.user_role_system.security;

import com.alibaba.fastjson.JSONObject;
import com.jinxiang.user_role_system.pojo.ResponseEntity;
import com.jinxiang.user_role_system.redis.RedisUtils;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器，用于签发token和存入redis
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private RedisUtils redisUtils;

    static long TTL =  60 * 60 * 24;

    @Value("${jwt.signature.secretKey}")
    private String SecretKey;

    @Value("${jwt.signature.issuer}")
    private String Issuer;

    protected SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {


    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {


        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuer(Issuer)
                .claim("username", authentication.getName())
                .signWith(signatureAlgorithm, SecretKey);
        String token = jwtBuilder.compact();


        redisUtils.set(token, authentication, TTL);

        JSONObject tokenJSON=new JSONObject();
        tokenJSON.put("token",token);


        String resStr = "";
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(new ResponseEntity<>(200, true, "登录成功", tokenJSON));
        response.setContentType("application/json;charset=utf-8");
        resStr = jsonObject.toJSONString();

        response.getWriter().write(resStr);
    }
}
