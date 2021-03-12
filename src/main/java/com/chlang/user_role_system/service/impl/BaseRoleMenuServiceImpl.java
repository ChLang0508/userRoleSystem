package com.chlang.user_role_system.service.impl;

import com.chlang.user_role_system.dao.BaseMenuMapper;
import com.chlang.user_role_system.dao.BaseRoleMapper;
import com.chlang.user_role_system.dao.BaseRoleMenuMapper;
import com.chlang.user_role_system.entity.BaseRoleMenu;
import com.chlang.user_role_system.service.BaseRoleMenuService;
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
