package com.chlang.user_role_system.controller;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.chlang.user_role_system.entity.BaseUser;
import com.chlang.user_role_system.entity.ResponseEntity;
import com.chlang.user_role_system.redis.RedisUtils;
import com.chlang.user_role_system.service.BaseUserServices;
import com.chlang.user_role_system.tool.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class BaseUserController {

    private static SerializeConfig jsonConfig = new SerializeConfig();

    static {
        jsonConfig.put(Date.class, new SimpleDateFormatSerializer(""));
    }

    @Autowired
    BaseUserServices baseUserServices;

    @Autowired
    RedisUtils redisUtils;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(HttpServletRequest request, BaseUser baseUser) {
        return null;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResponseEntity<?> delUser(HttpServletRequest request, Long userId) {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(HttpServletRequest request, BaseUser baseUser) {
        return null;
    }

    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ResponseEntity<?> getUser(HttpServletRequest request,
                                  BaseUser baseUser,
                                  Pager pager) {
        return null;
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    public ResponseEntity<?> updatePassword(HttpServletRequest request, Long userId) {
        return null;
    }


}
