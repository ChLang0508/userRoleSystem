package com.chlang.user_role_system.service.impl;

import com.chlang.user_role_system.dao.BaseRoleMapper;
import com.chlang.user_role_system.dao.BaseUserMapper;
import com.chlang.user_role_system.dao.BaseUserRoleMapper;
import com.chlang.user_role_system.service.BaseUserRoleService;
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
