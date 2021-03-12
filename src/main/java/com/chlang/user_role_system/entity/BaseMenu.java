package com.chlang.user_role_system.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 菜单表，存储菜单项和菜单url(BaseMenu)实体类
 *
 * @author makejava
 * @since 2021-03-12 18:20:27
 */
public class BaseMenu implements Serializable {
    private static final long serialVersionUID = -46785251462564970L;
    /**
     * ord
     */
    private Long ord;
    /**
     * 编码
     */
    private String code;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单深度
     */
    private Integer deep;
    /**
     * 状态（0--正常，1--停用）
     */
    private Integer status;
    /**
     * 是否叶子节点（1--是，0不是）
     */
    private Integer isEndNode;
    /**
     * 菜单url
     */
    private String menuUrl;
    /**
     * 创建人
     */
    private Long creater;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private Long updateUser;
    /**
     * 修改时间
     */
    private Date updateTime;


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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsEndNode() {
        return isEndNode;
    }

    public void setIsEndNode(Integer isEndNode) {
        this.isEndNode = isEndNode;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
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

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
