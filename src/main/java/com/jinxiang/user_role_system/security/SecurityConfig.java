package com.jinxiang.user_role_system.security;

/**
 * Created by chLang on 2019/11/16
 */

import com.jinxiang.user_role_system.services.BaseRoleMenuService;
import com.jinxiang.user_role_system.services.BaseUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.Arrays;
import java.util.List;


/**
 * spring security 配置文件
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private BaseRoleMenuService baseRoleMenuService;


    @Autowired
    private BaseUserServices baseUserServices;

    /**
     * 密码编码方式
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        String a = passwordEncoder().encode("cl");
        http
                //配置不拦截的url
                .authorizeRequests()
                .antMatchers("/noLogin", "/login","/successLogout")
                .permitAll()
                .accessDecisionManager(accessDecisionManager())
                //自定义拦截的URL的数据源，实现从数据库获取角色权限动态拦截url，而不是在这个类中配置
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(
                            O fsi) {
                        fsi.setSecurityMetadataSource(mySecurityMetadataSource(fsi.getSecurityMetadataSource()));
                        return fsi;
                    }
                })
//                .antMatchers("/test").hasAnyRole("ROLE_USER")
                //拦截所有
                .anyRequest()
                .authenticated()

                .and()
                //登录配置
                .formLogin()
                //用户名和密码参数名
                .usernameParameter("userName")
                .passwordParameter("password")
                //登录处理URL
                .loginProcessingUrl("/login")
                //登录页面，默认情况下未登录会跳转到这个url
                .loginPage("/noLogin")
                .failureForwardUrl("/filedLogin")
                .successForwardUrl("/successLogin")
//                .permitAll()
                .and()
                .logout()
//                .logoutUrl("")
                .logoutSuccessUrl("/successLogout")
//                .logoutSuccessHandler()
                .and()
                .exceptionHandling()
                //自定义未登录的处理，而不是跳转到默认登录页面
//                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                .and()
                //防止跨站伪造请求（跨域）
                .csrf().disable();
    }

//    @Autowired
//    public void myConfig(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(dbProvider);
//    }

    /**
     * 配置用户数据来源，可来自内存，数据库等
     *
     * @param auth
     * @throws Exception
     */
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(baseUserServices).passwordEncoder(passwordEncoder());
//        auth.inMemoryAuthentication().withUser("cl").password("{noop}cl").roles("user");
    }

    /**
     * 注入自定义的权限数据源
     *
     * @param filterInvocationSecurityMetadataSource
     * @return
     */
    @Bean
    public AppFilterInvocationSecurityMetadataSource mySecurityMetadataSource(FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource) {
        return new AppFilterInvocationSecurityMetadataSource(filterInvocationSecurityMetadataSource, baseRoleMenuService);
    }


    /**
     * 自定义多个投票器，以及投票方式
     * @return
     */
    @Bean
    public AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<?>> decisionVoters
                = Arrays.asList(
                new WebExpressionVoter(),
                new RoleVoter(),
                new AuthenticatedVoter()
//                new MinuteBasedVoter()
        );
        //一票通过（可选一票通过（全部弃权也通过），一票否决，少数服从多数）
        return new UnanimousBased(decisionVoters);
    }

}
