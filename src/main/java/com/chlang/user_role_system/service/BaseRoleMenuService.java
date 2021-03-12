package com.chlang.user_role_system.service;

import com.chlang.user_role_system.entity.BaseRoleMenu;

import java.util.List;

/**
 * 角色菜单表,这张表里有即为有权限(BaseRoleMenu)表服务接口
 *
 * @author makejava
 * @since 2021-03-12 18:25:42
 */
public interface BaseRoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    BaseRoleMenu queryById(Long ord);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseRoleMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseRoleMenu 实例对象
     * @return 实例对象
     */
    BaseRoleMenu insert(BaseRoleMenu baseRoleMenu);

    /**
     * 修改数据
     *
     * @param baseRoleMenu 实例对象
     * @return 实例对象
     */
    BaseRoleMenu update(BaseRoleMenu baseRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 是否成功
     */
    boolean deleteById(Long ord);

}
