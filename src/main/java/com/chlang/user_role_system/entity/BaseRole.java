package com.chlang.user_role_system.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色表，存储角色信息(BaseRole)实体类
 *
 * @author makejava
 * @since 2021-03-12 18:25:06
 */
public class BaseRole implements Serializable, GrantedAuthority {
    private static final long serialVersionUID = 535546087911894080L;
    /**
     * id
     */
    private Long ord;
    /**
     * 编码
     */
    private String code;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 状态（0--正常，1--停用）
     */
    private Integer status;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private Long createUser;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 修改人
     */
    private Long updateUser;


    public Long getOrd() {
        return ord;
    }

    public void setOrd(Long ord) {
        this.ord = ord;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}
