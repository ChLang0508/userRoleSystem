package com.jinxiang.user_role_system.dao;

import com.jinxiang.user_role_system.pojo.BaseRoleMenu;

public interface BaseRoleMenuMapper {
    int deleteByPrimaryKey(Long ord);

    int insert(BaseRoleMenu record);

    int insertSelective(BaseRoleMenu record);

    BaseRoleMenu selectByPrimaryKey(Long ord);

    int updateByPrimaryKeySelective(BaseRoleMenu record);

    int updateByPrimaryKey(BaseRoleMenu record);
}