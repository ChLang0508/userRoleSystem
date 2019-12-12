package com.jinxiang.user_role_system.sec;

import com.jinxiang.user_role_system.pojo.BaseUser;
import com.jinxiang.user_role_system.services.BaseUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DBProvider implements AuthenticationProvider {
    @Autowired
    BaseUserServices baseUserServices;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String userPass = (String) authentication.getCredentials();
        BaseUser userInfo = baseUserServices.selectUserByName(userName);

        if (userInfo != null) {

            if (userInfo.getUser_password().equals(userPass)) {
                return new UsernamePasswordAuthenticationToken(userName, userPass,
                        AuthorityUtils.commaSeparatedStringToAuthorityList("guest,admin"));

            } else {
                throw new BadCredentialsException("用户密码错误!");
            }

        } else {
            throw new UsernameNotFoundException("用户不存在!");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
