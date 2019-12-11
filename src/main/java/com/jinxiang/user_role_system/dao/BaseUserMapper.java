package com.jinxiang.user_role_system.dao;

import com.jinxiang.user_role_system.pojo.BaseUser;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(Long id);
    BaseUser selectByName(String name);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);
}