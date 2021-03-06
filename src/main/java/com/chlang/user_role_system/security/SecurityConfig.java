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
 * spring security ????????????
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
     * ??????????????????
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
                //??????????????????url
                .authorizeRequests()
                .antMatchers("/noLogin", "/login", "/successLogout")
                .permitAll()

                //??????????????????
                .accessDecisionManager(accessDecisionManager())
                //??????????????????URL???????????????????????????????????????????????????????????????url?????????????????????????????????
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(
                            O fsi) {
                        fsi.setSecurityMetadataSource(mySecurityMetadataSource(fsi.getSecurityMetadataSource()));
                        return fsi;
                    }
                })
//                .antMatchers("/test").hasAnyRole("ROLE_USER")
                //????????????
                .anyRequest()
                .authenticated()

                .and()
                //??????session??????,???disable?????????
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                //???????????????
                .addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                //????????????
                //???????????????form??????
                .formLogin()
//                .disable()
                //???????????????????????????
                .usernameParameter("userName")
                .passwordParameter("password")
                //????????????URL
                .loginProcessingUrl("/login")
                //?????????????????????????????????????????????????????????url
                .loginPage("/noLogin")

                .permitAll()
                .and()
                .logout()

                .logoutSuccessUrl("/successLogout")
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                //rememberMe??????
                .rememberMe()
                .and()
//                .exceptionHandling()
                //??????????????????????????????????????????????????????????????????
//                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//                .and()
                //????????????????????????
                .csrf().disable()
                //????????????
                .cors()
                .and()   //??????header????????????????????????ajax??????
                .headers().addHeaderWriter(new StaticHeadersWriter(Arrays.asList(
                new Header("Access-control-Allow-Origin", "*"),
                new Header("Access-Control-Expose-Headers", "Authorization"))))
                .and()
                //??????OPTIONS?????????????????????header
                .addFilterAfter(new OptionsRequestFilter(), CorsFilter.class)
                .addFilterAfter(jwtAuthenticationFilter, SecurityContextPersistenceFilter.class);

    }

    /**
     * ?????????????????????????????????????????????????????????
     *
     * @param auth
     * @throws Exception
     */
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider)
                .userDetailsService(baseUserServices).passwordEncoder(passwordEncoder());
    }

    /**
     * ?????????????????????????????????
     *
     * @param filterInvocationSecurityMetadataSource
     * @return
     */
    @Bean
    public AppFilterInvocationSecurityMetadataSource mySecurityMetadataSource(FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource) {
        return new AppFilterInvocationSecurityMetadataSource(filterInvocationSecurityMetadataSource, baseRoleMenuService);
    }


    /**
     * ?????????????????????????????????????????????
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
        //???????????????????????????????????????????????????????????????????????????????????????????????????
        return new UnanimousBased(decisionVoters);
    }


    /**
     * ???????????????????????????
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

        //??????WebSecurityConfigurerAdapter?????????AuthenticationManager?????????????????????AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

}

