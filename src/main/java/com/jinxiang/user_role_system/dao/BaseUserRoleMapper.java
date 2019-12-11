package com.jinxiang.user_role_system.dao;

import com.jinxiang.user_role_system.pojo.BaseUserRole;

public interface BaseUserRoleMapper {
    int deleteByPrimaryKey(Long ord);

    int insert(BaseUserRole record);

    int insertSelective(BaseUserRole record);

    BaseUserRole selectByPrimaryKey(Long ord);

    int updateByPrimaryKeySelective(BaseUserRole record);

    int updateByPrimaryKey(BaseUserRole record);
}