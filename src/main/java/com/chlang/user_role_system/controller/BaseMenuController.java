package com.chlang.user_role_system.controller;

import com.chlang.user_role_system.entity.BaseMenu;
import com.chlang.user_role_system.service.BaseMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 菜单表，存储菜单项和菜单url(BaseMenu)表控制层
 *
 * @author makejava
 * @since 2021-03-12 18:20:40
 */
@RestController
@RequestMapping("baseMenu")
public class BaseMenuController {
    /**
     * 服务对象
     */
    @Resource
    private BaseMenuService baseMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseMenu selectOne(Long id) {
        return this.baseMenuService.queryById(id);
    }

}
