package com.chlang.user_role_system.service;

import com.chlang.user_role_system.entity.BaseUserRole;

import java.util.List;

/**
 * 用户角色表(BaseUserRole)表服务接口
 *
 * @author makejava
 * @since 2021-03-12 18:28:47
 */
public interface BaseUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    BaseUserRole queryById(Long ord);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseUserRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseUserRole 实例对象
     * @return 实例对象
     */
    BaseUserRole insert(BaseUserRole baseUserRole);

    /**
     * 修改数据
     *
     * @param baseUserRole 实例对象
     * @return 实例对象
     */
    BaseUserRole update(BaseUserRole baseUserRole);

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 是否成功
     */
    boolean deleteById(Long ord);

}
