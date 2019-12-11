package com.jinxiang.user_role_system.config;

import com.jinxiang.user_role_system.sec.DBProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DBProvider dbProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .csrf().disable();

    }

    @Autowired
    public void myConfig(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(dbProvider);
    }

}

