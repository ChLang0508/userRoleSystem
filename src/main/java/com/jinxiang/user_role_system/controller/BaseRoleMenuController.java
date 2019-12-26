package com.jinxiang.user_role_system.controller;

import com.jinxiang.user_role_system.pojo.BaseRoleMenu;
import com.jinxiang.user_role_system.pojo.ResponseEntity;
import com.jinxiang.user_role_system.services.BaseRoleMenuService;
import com.jinxiang.user_role_system.tool.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/role-menu", method = RequestMethod.POST)
public class BaseRoleMenuController {

    @Autowired
    private BaseRoleMenuService baseRoleMenuService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addRoleMenu(HttpServletRequest request, BaseRoleMenu baseRoleMenu) {
        return null;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseEntity<?> delRoleMenu(HttpServletRequest request, Long ord) {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateRoleMenu(HttpServletRequest request, BaseRoleMenu baseRoleMenu) {
        return null;
    }

    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ResponseEntity<?> getRoleMenu(HttpServletRequest request,
                                      BaseRoleMenu baseRoleMenu,
                                      Pager pager) {
        return null;
    }

}
