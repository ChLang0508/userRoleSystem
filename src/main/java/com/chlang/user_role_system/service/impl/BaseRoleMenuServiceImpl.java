package com.chlang.user_role_system.service.impl;

import com.chlang.user_role_system.entity.BaseRoleMenu;
import com.chlang.user_role_system.dao.BaseRoleMenuDao;
import com.chlang.user_role_system.service.BaseRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色菜单表,这张表里有即为有权限(BaseRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2021-03-12 18:25:42
 */
@Service("baseRoleMenuService")
public class BaseRoleMenuServiceImpl implements BaseRoleMenuService {
    @Resource
    private BaseRoleMenuDao baseRoleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    @Override
    public BaseRoleMenu queryById(Long ord) {
        return this.baseRoleMenuDao.queryById(ord);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseRoleMenu> queryAllByLimit(int offset, int limit) {
        return this.baseRoleMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public BaseRoleMenu insert(BaseRoleMenu baseRoleMenu) {
        this.baseRoleMenuDao.insert(baseRoleMenu);
        return baseRoleMenu;
    }

    /**
     * 修改数据
     *
     * @param baseRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public BaseRoleMenu update(BaseRoleMenu baseRoleMenu) {
        this.baseRoleMenuDao.update(baseRoleMenu);
        return this.queryById(baseRoleMenu.getOrd());
    }

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long ord) {
        return this.baseRoleMenuDao.deleteById(ord) > 0;
    }
}
