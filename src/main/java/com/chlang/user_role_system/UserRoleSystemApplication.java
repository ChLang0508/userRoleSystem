package com.chlang.user_role_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chlang.user_role_system.dao")
public class UserRoleSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRoleSystemApplication.class, args);
    }

}
