package com.jinxiang.user_role_system.services;

import com.jinxiang.user_role_system.dao.BaseUserMapper;
import com.jinxiang.user_role_system.pojo.BaseMenu;
import com.jinxiang.user_role_system.pojo.BaseUser;

public interface BaseUserServices {
    BaseUser selectUserByName(String name);

}
