package com.jinxiang.user_role_system.dao;

import com.jinxiang.user_role_system.pojo.BaseMenu;
import com.jinxiang.user_role_system.pojo.BaseRole;
import com.jinxiang.user_role_system.pojo.BaseUser;
import com.jinxiang.user_role_system.tool.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(Long id);

    BaseUser selectByName(String name);

    BaseUser selectByCode(String code);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    List<BaseMenu> selectList(@Param("record") BaseUser record, @Param("pager") Pager pager);

    int selectListCount(@Param("record") BaseUser record);
}