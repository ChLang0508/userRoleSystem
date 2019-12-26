package com.jinxiang.user_role_system.services.impl;

import com.jinxiang.user_role_system.dao.BaseMenuMapper;
import com.jinxiang.user_role_system.services.BaseMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseMenuServiceImpl implements BaseMenuService {

    @Autowired
    private BaseMenuMapper baseMenuMapper;
}
