package com.chlang.user_role_system.service.impl;

import com.chlang.user_role_system.entity.BaseRole;
import com.chlang.user_role_system.dao.BaseRoleDao;
import com.chlang.user_role_system.service.BaseRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色表，存储角色信息(BaseRole)表服务实现类
 *
 * @author makejava
 * @since 2021-03-12 18:25:08
 */
@Service("baseRoleService")
public class BaseRoleServiceImpl implements BaseRoleService {
    @Resource
    private BaseRoleDao baseRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    @Override
    public BaseRole queryById(Long ord) {
        return this.baseRoleDao.queryById(ord);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseRole> queryAllByLimit(int offset, int limit) {
        return this.baseRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseRole 实例对象
     * @return 实例对象
     */
    @Override
    public BaseRole insert(BaseRole baseRole) {
        this.baseRoleDao.insert(baseRole);
        return baseRole;
    }

    /**
     * 修改数据
     *
     * @param baseRole 实例对象
     * @return 实例对象
     */
    @Override
    public BaseRole update(BaseRole baseRole) {
        this.baseRoleDao.update(baseRole);
        return this.queryById(baseRole.getOrd());
    }

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long ord) {
        return this.baseRoleDao.deleteById(ord) > 0;
    }
}
