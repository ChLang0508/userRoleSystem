package com.jinxiang.user_role_system.dao;

import com.jinxiang.user_role_system.pojo.BaseMenu;
import com.jinxiang.user_role_system.pojo.BaseRole;
import com.jinxiang.user_role_system.pojo.BaseUserRole;
import com.jinxiang.user_role_system.tool.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseUserRoleMapper {
    int deleteByPrimaryKey(Long ord);

    int insert(BaseUserRole record);

    int insertSelective(BaseUserRole record);

    BaseUserRole selectByPrimaryKey(Long ord);

    int updateByPrimaryKeySelective(BaseUserRole record);

    int updateByPrimaryKey(BaseUserRole record);

    List<BaseMenu> selectList(@Param("record") BaseUserRole record, @Param("pager") Pager pager);

    int selectListCount(@Param("record") BaseUserRole record);
}