package com.jinxiang.user_role_system.security;


import com.jinxiang.user_role_system.services.BaseUserServices;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 额外自定义的认证器，用于重写认证逻辑或新增认证逻辑
 */
@Component
public class CustomerAuthenticationProvider extends DaoAuthenticationProvider {

    CustomerAuthenticationProvider(BaseUserServices baseUserServices, PasswordEncoder encoder){
        this.setUserDetailsService(baseUserServices);
        this.setPasswordEncoder(encoder);
    }

    /**
     * 额外的认证逻辑写在这里
     * @param userDetails
     * @param authentication
     * @throws AuthenticationException
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        super.additionalAuthenticationChecks(userDetails, authentication);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
