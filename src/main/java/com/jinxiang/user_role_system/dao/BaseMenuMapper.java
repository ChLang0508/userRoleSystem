package com.jinxiang.user_role_system.dao;

import com.jinxiang.user_role_system.pojo.BaseMenu;
import com.jinxiang.user_role_system.tool.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseMenuMapper {
    int deleteByPrimaryKey(Long ord);

    int insert(BaseMenu record);

    int insertSelective(BaseMenu record);

    BaseMenu selectByPrimaryKey(Long ord);

    int updateByPrimaryKeySelective(BaseMenu record);

    int updateByPrimaryKey(BaseMenu record);

    List<BaseMenu> selectList(@Param("record") BaseMenu record, @Param("pager") Pager pager);

    int selectListCount(@Param("record") BaseMenu record);
}