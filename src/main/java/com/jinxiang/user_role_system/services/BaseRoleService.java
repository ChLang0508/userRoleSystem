package com.jinxiang.user_role_system.services;

import com.jinxiang.user_role_system.pojo.BaseRole;
import com.jinxiang.user_role_system.tool.Pager;

public interface BaseRoleService {


    BaseRole selectRoleByCode(String code);

    Boolean updateBySelective(BaseRole baseRole);

    Boolean insertRole(BaseRole baseRole)throws Exception;

    BaseRole getRoleByPK(Long roleID);

    Boolean delRole(Long roleID);

    Pager getRoleList(BaseRole role, Pager pager);

}
