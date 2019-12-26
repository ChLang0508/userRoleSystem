package com.jinxiang.user_role_system.controller;

import com.jinxiang.user_role_system.pojo.BaseUserRole;
import com.jinxiang.user_role_system.pojo.ResponseEntity;
import com.jinxiang.user_role_system.tool.Pager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user-role", method = RequestMethod.POST)
public class BaseUserRoleController {

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

}
