package com.chlang.user_role_system.service.impl;

import com.chlang.user_role_system.dao.BaseRoleDao;
import com.chlang.user_role_system.dao.BaseUserMapper;
import com.chlang.user_role_system.entity.BaseRole;
import com.chlang.user_role_system.entity.BaseUser;
import com.chlang.user_role_system.service.BaseUserServices;
import com.chlang.user_role_system.tool.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class BaseUserServicesImpl implements BaseUserServices {

    @Autowired
    private BaseUserMapper baseUserMapper;
    @Autowired
    private BaseRoleDao baseRoleMapper;


    @Override
    public BaseUser selectUserByCode(String code) {
        BaseUser baseUser = baseUserMapper.selectByCode(code);
        List<BaseRole> roles = baseRoleMapper.selectByUserId(baseUser.getId());
        baseUser.setRoleList(roles);
        return baseUser;
    }

    @Override
    public Boolean updateBySelective(BaseUser baseUser) {
        return baseUserMapper.updateByPrimaryKeySelective(baseUser) == 1;
    }

    @Override
    public Boolean insertUser(BaseUser baseUser) {
        //TODO 数据验证逻辑

        return baseUserMapper.insertSelective(baseUser)==1;
    }

    @Override
    public BaseUser getUserByPK(Long userID) {
        return baseUserMapper.selectByPrimaryKey(userID);
    }

    @Override
    public Boolean delUser(Long userID) {
        //TODO 删除验证逻辑，是否允许删除

        return baseUserMapper.deleteByPrimaryKey(userID) == 1;
    }

    @Override
    public Pager getUserList(BaseUser user, Pager pager) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        BaseUser baseUser = baseUserMapper.selectByName(s);
        List<BaseRole> roles = baseRoleMapper.selectByUserId(baseUser.getId());
        baseUser.setRoleList(roles);
        return baseUser;
    }


}
