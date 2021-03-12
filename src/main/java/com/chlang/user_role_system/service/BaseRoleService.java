package com.chlang.user_role_system.service;

import com.chlang.user_role_system.entity.BaseRole;

import java.util.List;

/**
 * 角色表，存储角色信息(BaseRole)表服务接口
 *
 * @author makejava
 * @since 2021-03-12 18:25:07
 */
public interface BaseRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    BaseRole queryById(Long ord);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseRole 实例对象
     * @return 实例对象
     */
    BaseRole insert(BaseRole baseRole);

    /**
     * 修改数据
     *
     * @param baseRole 实例对象
     * @return 实例对象
     */
    BaseRole update(BaseRole baseRole);

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 是否成功
     */
    boolean deleteById(Long ord);

}
