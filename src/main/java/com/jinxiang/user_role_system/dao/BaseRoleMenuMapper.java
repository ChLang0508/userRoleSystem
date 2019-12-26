package com.jinxiang.user_role_system.dao;

import com.jinxiang.user_role_system.pojo.BaseMenu;
import com.jinxiang.user_role_system.pojo.BaseRole;
import com.jinxiang.user_role_system.pojo.BaseRoleMenu;
import com.jinxiang.user_role_system.tool.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRoleMenuMapper {
    int deleteByPrimaryKey(Long ord);

    int insert(BaseRoleMenu record);

    int insertSelective(BaseRoleMenu record);

    BaseRoleMenu selectByPrimaryKey(Long ord);

    int updateByPrimaryKeySelective(BaseRoleMenu record);

    int updateByPrimaryKey(BaseRoleMenu record);

    List<BaseRoleMenu> findAll();

    List<BaseMenu> selectList(@Param("record") BaseRoleMenu record, @Param("pager") Pager pager);

    int selectListCount(@Param("record") BaseRoleMenu record);
}