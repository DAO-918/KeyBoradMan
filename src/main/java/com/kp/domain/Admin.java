package com.kp.domain;

import java.util.Date;
import lombok.Data;


public class Admin {
    /**
    * 管理员id
    */
    private Integer admin_id;

    /**
    * 管理员账号名称
    */
    private String admin_login_name;

    /**
    * 管理员密码
    */
    private String admin_login_pwd;

    /**
    * 管理员最后登录时间
    */
    private String admin_login_date;

    @Override
    public String toString() {
        return "admin{" +
                "admin_id=" + admin_id +
                ", admin_login_name='" + admin_login_name + '\'' +
                ", admin_login_pwd='" + admin_login_pwd + '\'' +
                ", admin_login_date='" + admin_login_date + '\'' +
                '}';
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_login_name() {
        return admin_login_name;
    }

    public void setAdmin_login_name(String admin_login_name) {
        this.admin_login_name = admin_login_name;
    }

    public String getAdmin_login_pwd() {
        return admin_login_pwd;
    }

    public void setAdmin_login_pwd(String admin_login_pwd) {
        this.admin_login_pwd = admin_login_pwd;
    }

    public String getAdmin_login_date() {
        return admin_login_date;
    }

    public void setAdmin_login_date(String admin_login_date) {
        this.admin_login_date = admin_login_date;
    }
}