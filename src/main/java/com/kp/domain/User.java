package com.kp.domain;

import lombok.Data;

@Data
public class User {
    private Integer userId;

    /**
    * 用户名
    */
    private String userName;

    /**
    * 账户密码
    */
    private String userPassword;

    /**
    * 使用手机号码注册
    */
    private Long userPhone;

    /**
    * 用户状态 0：未激活 1：激活
    */
    private Integer userStatus;
}