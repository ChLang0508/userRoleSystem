package com.chlang.user_role_system.service.impl;

import com.chlang.user_role_system.dao.BaseRoleMapper;
import com.chlang.user_role_system.entity.BaseRole;
import com.chlang.user_role_system.service.BaseRoleService;
import com.chlang.user_role_system.tool.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class BaseRoleServiceImpl implements BaseRoleService {
    @Autowired
    private BaseRoleMapper baseRoleMapper;


    @Override
    public BaseRole selectRoleByCode(String code) {
        return baseRoleMapper.selectByCode(code);
    }

    @Override
    public Boolean updateBySelective(BaseRole baseRole) throws Exception {
        return baseRoleMapper.updateByPrimaryKeySelective(baseRole) == 1;
    }

    @Override
    public Boolean insertRole(BaseRole baseRole) throws Exception {
        if (baseRoleMapper.selectByCode(baseRole.getCode()) != null) {
            throw new Exception("编码重复，请重新填写编码");
        }
        return baseRoleMapper.insertSelective(baseRole) == 1;
    }

    @Override
    public BaseRole getRoleByPK(Long roleID) {
        return baseRoleMapper.selectByPrimaryKey(roleID);
    }

    @Override
    public Boolean delRole(Long roleID) {
        return baseRoleMapper.deleteByPrimaryKey(roleID) == 1;
    }

    @Override
    public Pager getRoleList(BaseRole role, Pager pager) {
        List<BaseRole> roleList = baseRoleMapper.selectList(role, pager);
        int count = baseRoleMapper.selectListCount(role);
        pager.setList(roleList);
        pager.setTotalRow(count);
        return pager;
    }
}
