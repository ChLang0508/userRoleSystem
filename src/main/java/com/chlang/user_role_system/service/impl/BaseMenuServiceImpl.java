package com.chlang.user_role_system.service.impl;

import com.chlang.user_role_system.entity.BaseMenu;
import com.chlang.user_role_system.dao.BaseMenuDao;
import com.chlang.user_role_system.service.BaseMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单表，存储菜单项和菜单url(BaseMenu)表服务实现类
 *
 * @author makejava
 * @since 2021-03-12 18:20:39
 */
@Service("baseMenuService")
public class BaseMenuServiceImpl implements BaseMenuService {
    @Resource
    private BaseMenuDao baseMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    @Override
    public BaseMenu queryById(Long ord) {
        return this.baseMenuDao.queryById(ord);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseMenu> queryAllByLimit(int offset, int limit) {
        return this.baseMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseMenu 实例对象
     * @return 实例对象
     */
    @Override
    public BaseMenu insert(BaseMenu baseMenu) {
        this.baseMenuDao.insert(baseMenu);
        return baseMenu;
    }

    /**
     * 修改数据
     *
     * @param baseMenu 实例对象
     * @return 实例对象
     */
    @Override
    public BaseMenu update(BaseMenu baseMenu) {
        this.baseMenuDao.update(baseMenu);
        return this.queryById(baseMenu.getOrd());
    }

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long ord) {
        return this.baseMenuDao.deleteById(ord) > 0;
    }
}
