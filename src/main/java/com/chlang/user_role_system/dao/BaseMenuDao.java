package com.chlang.user_role_system.dao;

import com.chlang.user_role_system.entity.BaseMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单表，存储菜单项和菜单url(BaseMenu)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-12 18:20:33
 */
@Repository
public interface BaseMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ord 主键
     * @return 实例对象
     */
    BaseMenu queryById(Long ord);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BaseMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseMenu 实例对象
     * @return 对象列表
     */
    List<BaseMenu> queryAll(BaseMenu baseMenu);

    /**
     * 新增数据
     *
     * @param baseMenu 实例对象
     * @return 影响行数
     */
    int insert(BaseMenu baseMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BaseMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BaseMenu> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BaseMenu> entities);

    /**
     * 修改数据
     *
     * @param baseMenu 实例对象
     * @return 影响行数
     */
    int update(BaseMenu baseMenu);

    /**
     * 通过主键删除数据
     *
     * @param ord 主键
     * @return 影响行数
     */
    int deleteById(Long ord);

}

