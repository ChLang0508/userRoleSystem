package com.chlang.user_role_system.service.impl;

import com.chlang.user_role_system.dao.BaseMenuMapper;
import com.chlang.user_role_system.service.BaseMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseMenuServiceImpl implements BaseMenuService {

    @Autowired
    private BaseMenuMapper baseMenuMapper;
}
