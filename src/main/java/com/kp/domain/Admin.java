package com.kp.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Admin {
    /**
    * 管理员id
    */
    private Integer adminId;

    /**
    * 管理员账号名称
    */
    private String adminLoginName;

    /**
    * 管理员密码
    */
    private String adminLoginPwd;

    /**
    * 管理员最后登录时间
    */
    private Date adminLoginDate;
}