package com.chlang.user_role_system.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户角色表(BaseUserRole)实体类
 *
 * @author makejava
 * @since 2021-03-12 18:28:45
 */
public class BaseUserRole implements Serializable {
    private static final long serialVersionUID = -11592866428098907L;

    private Long ord;

    private Long userId;

    private Long roleId;

    private Long creater;

    private Date createTime;


    public Long getOrd() {
        return ord;
    }

    public void setOrd(Long ord) {
        this.ord = ord;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
