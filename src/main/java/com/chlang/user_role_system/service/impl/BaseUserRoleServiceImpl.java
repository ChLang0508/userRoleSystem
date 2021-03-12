package com.chlang.user_role_system.service.impl;

import com.chlang.user_role_system.entity.BaseUserRole;
import com.chlang.user_role_system.dao.BaseUserRoleDao;
import com.chlang.user_role_system.service.BaseUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色表(BaseUserRole)表服务实现类
 *
 * @author makejava
 * @since 2021-03-12 18:28:48
 */
@Service("baseUserRoleService")
public class BaseUserRoleServiceImpl implements BaseUserRoleService {
    @Resource
    private BaseUserRoleDao baseUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    @Override
    public BaseUserRole queryById(Long ord) {
        return this.baseUserRoleDao.queryById(ord);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseUserRole> queryAllByLimit(int offset, int limit) {
        return this.baseUserRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public BaseUserRole insert(BaseUserRole baseUserRole) {
        this.baseUserRoleDao.insert(baseUserRole);
        return baseUserRole;
    }

    /**
     * 修改数据
     *
     * @param baseUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public BaseUserRole update(BaseUserRole baseUserRole) {
        this.baseUserRoleDao.update(baseUserRole);
        return this.queryById(baseUserRole.getOrd());
    }

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long ord) {
        return this.baseUserRoleDao.deleteById(ord) > 0;
    }
}
