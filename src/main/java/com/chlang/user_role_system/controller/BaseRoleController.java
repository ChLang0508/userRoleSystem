package com.chlang.user_role_system.controller;

import com.chlang.user_role_system.entity.BaseRole;
import com.chlang.user_role_system.service.BaseRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色表，存储角色信息(BaseRole)表控制层
 *
 * @author makejava
 * @since 2021-03-12 18:25:09
 */
@RestController
@RequestMapping("baseRole")
public class BaseRoleController {
    /**
     * 服务对象
     */
    @Resource
    private BaseRoleService baseRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseRole selectOne(Long id) {
        return this.baseRoleService.queryById(id);
    }

}
