package com.chlang.user_role_system.dao;

import com.chlang.user_role_system.entity.BaseRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单表,这张表里有即为有权限(BaseRoleMenu)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-12 18:25:42
 */
public interface BaseRoleMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    BaseRoleMenu queryById(Long ord);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseRoleMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseRoleMenu 实例对象
     * @return 对象列表
     */
    List<BaseRoleMenu> queryAll(BaseRoleMenu baseRoleMenu);

    /**
     * 新增数据
     *
     * @param baseRoleMenu 实例对象
     * @return 影响行数
     */
    int insert(BaseRoleMenu baseRoleMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseRoleMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseRoleMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseRoleMenu> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseRoleMenu> entities);

    /**
     * 修改数据
     *
     * @param baseRoleMenu 实例对象
     * @return 影响行数
     */
    int update(BaseRoleMenu baseRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 影响行数
     */
    int deleteById(Long ord);

}

