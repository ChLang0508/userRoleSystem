package com.jinxiang.user_role_system.services.impl;

import com.jinxiang.user_role_system.dao.BaseRoleMapper;
import com.jinxiang.user_role_system.dao.BaseUserMapper;
import com.jinxiang.user_role_system.dao.BaseUserRoleMapper;
import com.jinxiang.user_role_system.pojo.BaseRole;
import com.jinxiang.user_role_system.pojo.BaseUser;
import com.jinxiang.user_role_system.services.BaseUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseUserRoleServiceImpl implements BaseUserRoleService {

    @Autowired
    private BaseRoleMapper baseRoleMapper;
    @Autowired
    private BaseUserMapper baseUserMapper;
    @Autowired
    private BaseUserRoleMapper baseUserRoleMapper;
}
