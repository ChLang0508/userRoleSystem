package com.chlang.user_role_system.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.chlang.user_role_system.entity.ResponseEntity;
import com.chlang.user_role_system.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登录成功处理器,清除redis
 */
@Component
public class CustomerLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        response.setContentType("application/json;charset=utf-8");

        String token = request.getHeader("token");

        JSONObject jsonObject = new JSONObject();

        if (StringUtils.isEmpty(token)) {
            jsonObject = (JSONObject) JSONObject.toJSON(new ResponseEntity<>(401, false, "未登录", null));

        } else {
            if (!redisUtils.hasKey(token)) {
                jsonObject = (JSONObject) JSONObject.toJSON(new ResponseEntity<>(401, false, "未登录", null));

            } else {
                jsonObject = (JSONObject) JSONObject.toJSON(new ResponseEntity<>(200, true, "退出成功", null));

            }
        }
        redisUtils.del(token);
        SecurityContextHolder.clearContext();
        String resStr = jsonObject.toJSONString();
        response.getWriter().write(resStr);
    }
}
