package com.kp.dao;

import com.kp.domain.Admin;

import java.util.List;

public interface AdminDao {

    /**
     * 查询所有管理员资料
     * 可带条件查询
     */
    List<Admin> findAll(Admin admin);


    /**
     * 查询所有记录
     */
    int findAdminCount();


    /**
     * 添加管理员
     */
    void addAdmin(Admin admin);

    /**
     * 删除管理员
     */
    void deleteAdmin(Integer uid);

    /**
     * 登陆
     */
    List<Admin> loginAdmin(Admin admin);


    /**
     * 修改最后一次登陆时间
     */
    void updateLoginTime(Admin admin);
}
