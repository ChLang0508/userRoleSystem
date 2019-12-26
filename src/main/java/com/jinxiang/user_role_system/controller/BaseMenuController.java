package com.jinxiang.user_role_system.controller;

import com.jinxiang.user_role_system.pojo.BaseMenu;
import com.jinxiang.user_role_system.pojo.ResponseEntity;
import com.jinxiang.user_role_system.services.BaseMenuService;
import com.jinxiang.user_role_system.tool.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/menu", method = RequestMethod.POST)
public class BaseMenuController {

    @Autowired
    private BaseMenuService baseMenuService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addMenu(HttpServletRequest request, BaseMenu baseMenu) {
        return null;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseEntity<?> delMenu(HttpServletRequest request, Long userId) {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateMenu(HttpServletRequest request, BaseMenu baseMenu) {
        return null;
    }

    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ResponseEntity<?> getMenu(HttpServletRequest request, BaseMenu baseMenu, Pager pager) {
        return null;
    }

}
