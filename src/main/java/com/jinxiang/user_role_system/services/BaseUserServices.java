package com.jinxiang.user_role_system.services;


import com.jinxiang.user_role_system.pojo.BaseUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface BaseUserServices extends UserDetailsService {

    BaseUser selectUserByName(String name);

    BaseUser selectUserByCode(String code);

    Boolean updateBySelective(BaseUser baseUser);

}
