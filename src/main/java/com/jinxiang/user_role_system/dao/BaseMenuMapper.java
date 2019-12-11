package com.jinxiang.user_role_system.dao;

import com.jinxiang.user_role_system.pojo.BaseMenu;

public interface BaseMenuMapper {
    int deleteByPrimaryKey(Long ord);

    int insert(BaseMenu record);

    int insertSelective(BaseMenu record);

    BaseMenu selectByPrimaryKey(Long ord);

    int updateByPrimaryKeySelective(BaseMenu record);

    int updateByPrimaryKey(BaseMenu record);
}