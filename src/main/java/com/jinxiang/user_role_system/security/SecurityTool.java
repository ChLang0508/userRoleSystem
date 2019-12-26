package com.jinxiang.user_role_system.security;

import com.jinxiang.user_role_system.pojo.BaseUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityTool {

    public static BaseUser getUser() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return null;
    }
}
