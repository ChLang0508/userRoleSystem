package com.jinxiang.user_role_system.security.customerFiter;

import com.jinxiang.user_role_system.pojo.BaseUser;
import com.jinxiang.user_role_system.redis.RedisUtils;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    protected RedisUtils redisUtils;

    @Value("${jwt.signature.secretKey}")
    protected String SecretKey;

    @Value("${jwt.signature.issuer}")
    protected String Issuer;

//    protected SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        Authentication user = (Authentication) redisUtils.get(token);
        if (user != null) {
//            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getCode(), "", user.getAuthorities()));

            SecurityContextHolder.getContext().setAuthentication(user);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        return;
    }
}
