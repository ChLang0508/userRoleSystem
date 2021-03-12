package com.chlang.user_role_system.controller;

import com.chlang.user_role_system.entity.BaseRole;
import com.chlang.user_role_system.entity.BaseUser;
import com.chlang.user_role_system.entity.BaseUserRole;
import com.chlang.user_role_system.entity.ResponseEntity;
import com.chlang.user_role_system.security.SecurityTool;
import com.chlang.user_role_system.service.BaseRoleService;
import com.chlang.user_role_system.tool.Pager;
import com.jinxiang.user_role_system.pojo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user-role", method = RequestMethod.POST)
public class BaseUserRoleController {

    @Resource
    private BaseRoleService baseRoleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addUserRole(HttpServletRequest request, BaseUserRole baseUserRole) {
        return null;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseEntity<?> delUserRole(HttpServletRequest request, Long userId) {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateUserRole(HttpServletRequest request, BaseUserRole baseUserRole) {
        return null;
    }

    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ResponseEntity<?> getUserRole(HttpServletRequest request,
                                         BaseUserRole baseUserRole,
                                         Pager pager) {
        return null;
    }

    @RequestMapping(value = "/get-menu", method = RequestMethod.POST)
    public ResponseEntity<?> getMenu() {
        BaseUser user = SecurityTool.getUser();
        for (BaseRole role : user.getRoleList()) {
//            List<BaseMenu> baseMenus=
        }
        return null;
    }


}
