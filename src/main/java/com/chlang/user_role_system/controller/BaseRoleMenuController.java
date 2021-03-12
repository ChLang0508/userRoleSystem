package com.chlang.user_role_system.controller;

import com.chlang.user_role_system.entity.BaseRoleMenu;
import com.chlang.user_role_system.service.BaseRoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色菜单表,这张表里有即为有权限(BaseRoleMenu)表控制层
 *
 * @author makejava
 * @since 2021-03-12 18:25:43
 */
@RestController
@RequestMapping("baseRoleMenu")
public class BaseRoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private BaseRoleMenuService baseRoleMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseRoleMenu selectOne(Long id) {
        return this.baseRoleMenuService.queryById(id);
    }

}
