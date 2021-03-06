package com.chlang.user_role_system.security;

/**
 * Created by chLang on 2019/12/16
 */

import com.chlang.user_role_system.security.customerFiter.CustomerUsernamePasswordAuthenticationFilter;
import com.chlang.user_role_system.security.customerFiter.JWTAuthenticationFilter;
import com.chlang.user_role_system.security.customerFiter.OptionsRequestFilter;
import com.chlang.user_role_system.security.handler.CustomerLogoutSuccessHandler;
import com.chlang.user_role_system.security.handler.LoginFiledHandler;
import com.chlang.user_role_system.security.handler.LoginSuccessHandler;
import com.chlang.user_role_system.security.provider.CustomerAuthenticationProvider;
import com.chlang.user_role_system.service.BaseRoleMenuService;
import com.chlang.user_role_system.service.BaseUserServices;
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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.filter.CorsFilter;

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
    private CustomerAuthenticationProvider authenticationProvider;

    @Autowired
    private BaseUserServices baseUserServices;

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private CustomerLogoutSuccessHandler logoutSuccessHandler;

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

        http
                //配置不拦截的url
                .authorizeRequests()
                .antMatchers("/noLogin", "/login", "/successLogout")
                .permitAll()

                //自定义投票器
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
                //关闭session支持,用disable关不掉
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                //替换过滤器
                .addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                //登录配置
                //关闭默认的form登录
                .formLogin()
//                .disable()
                //用户名和密码参数名
                .usernameParameter("userName")
                .passwordParameter("password")
                //登录处理URL
                .loginProcessingUrl("/login")
                //登录页面，默认情况下未登录会跳转到这个url
                .loginPage("/noLogin")

                .permitAll()
                .and()
                .logout()

                .logoutSuccessUrl("/successLogout")
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                //rememberMe配置
                .rememberMe()
                .and()
//                .exceptionHandling()
                //自定义未登录的处理，而不是跳转到默认登录页面
//                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//                .and()
                //防止跨站伪造请求
                .csrf().disable()
                //支持跨域
                .cors()
                .and()   //添加header设置，支持跨域和ajax请求
                .headers().addHeaderWriter(new StaticHeadersWriter(Arrays.asList(
                new Header("Access-control-Allow-Origin", "*"),
                new Header("Access-Control-Expose-Headers", "Authorization"))))
                .and()
                //拦截OPTIONS请求，直接返回header
                .addFilterAfter(new OptionsRequestFilter(), CorsFilter.class)
                .addFilterAfter(jwtAuthenticationFilter, SecurityContextPersistenceFilter.class);

    }

    /**
     * 配置用户数据来源，可来自内存，数据库等
     *
     * @param auth
     * @throws Exception
     */
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider)
                .userDetailsService(baseUserServices).passwordEncoder(passwordEncoder());
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
     *
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


    /**
     * 注册自定义的过滤器
     *
     * @return
     * @throws Exception
     */
    @Bean
    CustomerUsernamePasswordAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomerUsernamePasswordAuthenticationFilter filter = new CustomerUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(loginSuccessHandler);
        filter.setAuthenticationFailureHandler(new LoginFiledHandler());
        filter.setFilterProcessesUrl("/login");
        filter.setSessionAuthenticationStrategy(new NullAuthenticatedSessionStrategy());

        //重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不再重新组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

}

