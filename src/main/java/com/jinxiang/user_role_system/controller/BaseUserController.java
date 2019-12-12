package com.jinxiang.user_role_system.controller;

import com.jinxiang.user_role_system.dao.BaseMenuMapper;
import com.jinxiang.user_role_system.dao.BaseUserMapper;
import com.jinxiang.user_role_system.pojo.BaseMenu;
import com.jinxiang.user_role_system.pojo.BaseUser;
import com.jinxiang.user_role_system.services.BaseUserServices;
import com.jinxiang.user_role_system.services.impl.BaseUserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BaseUserController {

    @Autowired
    BaseUserServices baseUserServices;


    @GetMapping("/public/admin")
    public BaseUser getUser(){
        BaseUser admin = baseUserServices.selectUserByName("admin");
        return admin;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }


}
