package com.jinxiang.user_role_system.dao;

import com.jinxiang.user_role_system.pojo.BaseRole;

public interface BaseRoleMapper {
    int deleteByPrimaryKey(Long ord);

    int insert(BaseRole record);

    int insertSelective(BaseRole record);

    BaseRole selectByPrimaryKey(Long ord);

    int updateByPrimaryKeySelective(BaseRole record);

    int updateByPrimaryKey(BaseRole record);
}