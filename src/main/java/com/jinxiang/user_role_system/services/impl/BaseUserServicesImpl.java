package com.jinxiang.user_role_system.services.impl;

import com.jinxiang.user_role_system.dao.BaseMenuMapper;
import com.jinxiang.user_role_system.dao.BaseRoleMapper;
import com.jinxiang.user_role_system.dao.BaseUserMapper;
import com.jinxiang.user_role_system.pojo.BaseMenu;
import com.jinxiang.user_role_system.pojo.BaseRole;
import com.jinxiang.user_role_system.pojo.BaseUser;
import com.jinxiang.user_role_system.services.BaseUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseUserServicesImpl implements BaseUserServices {

    @Autowired
    private BaseUserMapper baseUserMapper;
    @Autowired
    private BaseRoleMapper baseRoleMapper;




    @Override
    public BaseUser selectUserByCode(String code) {
        BaseUser baseUser = baseUserMapper.selectByCode(code);
        List<BaseRole> roles = baseRoleMapper.selectByUserId(baseUser.getId());
        baseUser.setRoleList(roles);
        return baseUser;
    }

    @Override
    public Boolean updateBySelective(BaseUser baseUser) {
        return baseUserMapper.updateByPrimaryKeySelective(baseUser) == 1;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        BaseUser baseUser = baseUserMapper.selectByName(s);
        List<BaseRole> roles = baseRoleMapper.selectByUserId(baseUser.getId());
        baseUser.setRoleList(roles);
        return baseUser;
    }


}
