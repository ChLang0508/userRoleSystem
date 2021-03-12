package com.chlang.user_role_system.service;

import com.chlang.user_role_system.entity.BaseRole;
import com.chlang.user_role_system.tool.Pager;

public interface BaseRoleService {


    BaseRole selectRoleByCode(String code);

    Boolean updateBySelective(BaseRole baseRole)throws Exception;

    Boolean insertRole(BaseRole baseRole)throws Exception;

    BaseRole getRoleByPK(Long roleID);

    Boolean delRole(Long roleID);

    Pager getRoleList(BaseRole role, Pager pager);

}
