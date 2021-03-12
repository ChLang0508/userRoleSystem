package com.chlang.user_role_system.controller;

import com.chlang.user_role_system.entity.BaseUserRole;
import com.chlang.user_role_system.service.BaseUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户角色表(BaseUserRole)表控制层
 *
 * @author makejava
 * @since 2021-03-12 18:28:48
 */
@RestController
@RequestMapping("baseUserRole")
public class BaseUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private BaseUserRoleService baseUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BaseUserRole selectOne(Long id) {
        return this.baseUserRoleService.queryById(id);
    }

}
