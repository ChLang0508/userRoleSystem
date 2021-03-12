package com.chlang.user_role_system.service;

import com.chlang.user_role_system.entity.BaseMenu;

import java.util.List;

/**
 * 菜单表，存储菜单项和菜单url(BaseMenu)表服务接口
 *
 * @author makejava
 * @since 2021-03-12 18:20:39
 */
public interface BaseMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    BaseMenu queryById(Long ord);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseMenu 实例对象
     * @return 实例对象
     */
    BaseMenu insert(BaseMenu baseMenu);

    /**
     * 修改数据
     *
     * @param baseMenu 实例对象
     * @return 实例对象
     */
    BaseMenu update(BaseMenu baseMenu);

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 是否成功
     */
    boolean deleteById(Long ord);

}
