package com.jinxiang.user_role_system.services.impl;

import com.jinxiang.user_role_system.dao.BaseMenuMapper;
import com.jinxiang.user_role_system.dao.BaseUserMapper;
import com.jinxiang.user_role_system.pojo.BaseMenu;
import com.jinxiang.user_role_system.pojo.BaseUser;
import com.jinxiang.user_role_system.services.BaseUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseUserServicesImpl implements BaseUserServices {

    @Autowired
    private BaseUserMapper baseUserMapper;


    @Override
    public BaseUser selectUserByName(String name) {
        return baseUserMapper.selectByName(name);
    }
}
