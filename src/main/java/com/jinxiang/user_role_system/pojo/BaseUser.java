package com.jinxiang.user_role_system.pojo;

import java.util.Date;

public class BaseUser {
    private Long id;

    private String code;

    private String user_name;

    private String user_phone;

    private String user_email;

    private String user_password;

    private Integer status;

    private Long creater;

    private Date create_time;

    private Long update_user;

    private Date update_time;

    private String last_login_ip;

    private Date last_login_time;

    private Integer login_count;

    private Integer is_lock_ip;

    private String lock_ip1;

    private String lock_ip2;

    private Integer is_admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone == null ? null : user_phone.trim();
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email == null ? null : user_email.trim();
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password == null ? null : user_password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(Long update_user) {
        this.update_user = update_user;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip == null ? null : last_login_ip.trim();
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public Integer getLogin_count() {
        return login_count;
    }

    public void setLogin_count(Integer login_count) {
        this.login_count = login_count;
    }

    public Integer getIs_lock_ip() {
        return is_lock_ip;
    }

    public void setIs_lock_ip(Integer is_lock_ip) {
        this.is_lock_ip = is_lock_ip;
    }

    public String getLock_ip1() {
        return lock_ip1;
    }

    public void setLock_ip1(String lock_ip1) {
        this.lock_ip1 = lock_ip1 == null ? null : lock_ip1.trim();
    }

    public String getLock_ip2() {
        return lock_ip2;
    }

    public void setLock_ip2(String lock_ip2) {
        this.lock_ip2 = lock_ip2 == null ? null : lock_ip2.trim();
    }

    public Integer getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Integer is_admin) {
        this.is_admin = is_admin;
    }
}