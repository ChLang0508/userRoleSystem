package com.jinxiang.user_role_system.security;


/**
 * Created by chLang on 2019/11/16
 */

import com.jinxiang.user_role_system.services.BaseRoleMenuService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.access.SecurityConfig;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.Map;

public class AppFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private FilterInvocationSecurityMetadataSource  superMetadataSource;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();




    private  Map<String,String> urlRoleMap;
//    {{
//        put("/open/**","ROLE_ANONYMOUS");
//        put("/health","ROLE_ANONYMOUS");
//        put("/restart","ROLE_ADMIN");
//        put("/demo","ROLE_USER");
//    }};

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public AppFilterInvocationSecurityMetadataSource(FilterInvocationSecurityMetadataSource expressionBasedFilterInvocationSecurityMetadataSource,
                                                     BaseRoleMenuService baseRoleMenuService){
        this.superMetadataSource = expressionBasedFilterInvocationSecurityMetadataSource;

        // TODO 从数据库加载权限配置

        urlRoleMap =baseRoleMenuService.findAll();
    }



    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();

        for(Map.Entry<String,String> entry:urlRoleMap.entrySet()){
            if(antPathMatcher.match(entry.getKey(),url)){
                return SecurityConfig.createList(entry.getValue());
            }
        }

        //  返回代码定义的默认配置
        return superMetadataSource.getAttributes(object);
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}

//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
//        return null;
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return false;
//    }
