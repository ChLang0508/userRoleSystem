package com.chlang.user_role_system.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色菜单表,这张表里有即为有权限(BaseRoleMenu)实体类
 *
 * @author makejava
 * @since 2021-03-12 18:25:41
 */
public class BaseRoleMenu implements Serializable {
    private static final long serialVersionUID = -44864066812368494L;

    private Long ord;

    private Long roleId;

    private String menuUrl;

    private String roleName;

    private Long menuId;

    private Long creater;

    private Date createTime;

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getOrd() {
        return ord;
    }

    public void setOrd(Long ord) {
        this.ord = ord;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
