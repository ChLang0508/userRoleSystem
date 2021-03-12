package com.chlang.user_role_system.controller;

import com.chlang.user_role_system.entity.BaseRole;
import com.chlang.user_role_system.entity.ResponseEntity;
import com.chlang.user_role_system.security.SecurityTool;
import com.chlang.user_role_system.service.BaseRoleService;
import com.chlang.user_role_system.tool.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping(value = "/role", method = RequestMethod.POST)
public class BaseRoleController {

    @Autowired
    private BaseRoleService baseRoleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addRole(HttpServletRequest request,
                                     BaseRole baseRole) {
        return null;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseEntity<?> delRole(HttpServletRequest request,
                                     Long userId) {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateRole(HttpServletRequest request,
                                        BaseRole baseRole) throws Exception{
        baseRole.setCreate_time(null);
        baseRole.setCreate_user(null);
        baseRole.setUpdate_time(new Date());
        baseRole.setUpdate_user(SecurityTool.getUser().getId());
        Boolean result = baseRoleService.updateBySelective(baseRole);
        if (result) {
            return new ResponseEntity<>();
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ResponseEntity<?> getRole(HttpServletRequest request,
                                     BaseRole baseRole,
                                     Pager pager) {
        pager = baseRoleService.getRoleList(baseRole, pager);
        return new ResponseEntity<>(200, true, "", pager);
    }

    @RequestMapping(value = "/check-code", method = RequestMethod.POST)
    public ResponseEntity<?> checkCode(HttpServletRequest request,
                                       String code) {
        if (baseRoleService.selectRoleByCode(code) == null)
            return new ResponseEntity<>(1500, false, "编码重复，请重新输入", null);
        else
            return new ResponseEntity<>(200, true, "编码可用", null);
    }

}
