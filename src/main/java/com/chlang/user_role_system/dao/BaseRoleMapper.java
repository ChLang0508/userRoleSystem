package com.chlang.user_role_system.dao;

import com.chlang.user_role_system.entity.BaseRole;
import com.chlang.user_role_system.tool.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRoleMapper {
    int deleteByPrimaryKey(Long ord);

    int insert(BaseRole record);

    int insertSelective(BaseRole record);

    BaseRole selectByPrimaryKey(Long ord);

    int updateByPrimaryKeySelective(BaseRole record);

    int updateByPrimaryKey(BaseRole record);

    List<BaseRole> selectByUserId(@Param("userId") Long userId);

    List<BaseRole> selectList(@Param("record") BaseRole record, @Param("pager") Pager pager);

    int selectListCount(@Param("record") BaseRole record);

    BaseRole selectByCode(@Param("code") String code);
}