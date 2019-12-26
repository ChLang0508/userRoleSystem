package com.jinxiang.user_role_system.services.impl;

import com.jinxiang.user_role_system.dao.BaseMenuMapper;
import com.jinxiang.user_role_system.dao.BaseRoleMapper;
import com.jinxiang.user_role_system.dao.BaseRoleMenuMapper;
import com.jinxiang.user_role_system.pojo.BaseRole;
import com.jinxiang.user_role_system.pojo.BaseRoleMenu;
import com.jinxiang.user_role_system.services.BaseRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseRoleMenuServiceImpl implements BaseRoleMenuService {

    @Autowired
    private BaseRoleMenuMapper baseRoleMenuMapper;
    @Autowired
    private BaseMenuMapper baseMenuMapper;
    @Autowired
    private BaseRoleMapper baseRoleMapper;

    @Override
    public Map<String, String> findAll() {
        List<BaseRoleMenu> roleMenus=baseRoleMenuMapper.findAll();
        Map<String,String> map=new HashMap<>();
        for(BaseRoleMenu roleMenu:roleMenus){
            map.put(roleMenu.getMenuUrl(),roleMenu.getRoleName());
        }
        return map;
    }
}
