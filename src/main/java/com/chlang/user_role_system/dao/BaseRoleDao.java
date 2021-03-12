package com.chlang.user_role_system.dao;

import com.chlang.user_role_system.entity.BaseRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表，存储角色信息(BaseRole)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-12 18:25:07
 */
public interface BaseRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    BaseRole queryById(Long ord);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseRole 实例对象
     * @return 对象列表
     */
    List<BaseRole> queryAll(BaseRole baseRole);

    /**
     * 新增数据
     *
     * @param baseRole 实例对象
     * @return 影响行数
     */
    int insert(BaseRole baseRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseRole> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseRole> entities);

    /**
     * 修改数据
     *
     * @param baseRole 实例对象
     * @return 影响行数
     */
    int update(BaseRole baseRole);

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 影响行数
     */
    int deleteById(Long ord);

}

