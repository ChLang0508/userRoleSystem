package com.jinxiang.user_role_system.controller;

import com.jinxiang.user_role_system.pojo.ResponseEntity;
import com.jinxiang.user_role_system.services.BaseUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BaseUserController {

    @Autowired
    BaseUserServices baseUserServices;


    //    @RequestMapping("/login")
//    public ResponseEntity getUser(@RequestParam String userName,
//                                  @RequestParam String passWord){
//        return null;
//    }
    @RequestMapping("/noLogin")
    public ResponseEntity noLogin() {
        return new ResponseEntity(401,false,"尚未登录",null);
    }

    @RequestMapping("/filedLogin")
    public ResponseEntity filedLogin() {
        return new ResponseEntity(401,false,"登录失败",null);
    }
    @RequestMapping("/successLogin")
    public ResponseEntity successLogin() {
        return new ResponseEntity(401,false,"登录成功",null);
    }


    @RequestMapping("/test")
    public ResponseEntity test() {
        return new ResponseEntity(0,true,"test",null);
    }

    @RequestMapping("/ttt")
    public ResponseEntity ttt() {
        return new ResponseEntity(0,true,"ttt",null);
    }

    @RequestMapping("/user")
    public Authentication user(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
