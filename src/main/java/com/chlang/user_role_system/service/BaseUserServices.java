package com.chlang.user_role_system.service;


import com.chlang.user_role_system.entity.BaseUser;
import com.chlang.user_role_system.tool.Pager;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface BaseUserServices extends UserDetailsService {


    BaseUser selectUserByCode(String code);

    Boolean updateBySelective(BaseUser baseUser);

    Boolean insertUser(BaseUser baseUser);

    BaseUser getUserByPK(Long userID);

    Boolean delUser(Long userID);

    Pager getUserList(BaseUser user,Pager pager);

}
