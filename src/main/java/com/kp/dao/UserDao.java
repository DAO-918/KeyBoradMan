package com.kp.dao;

import com.kp.domain.User;

public interface UserDao {

    /**
     *
     * 禁用用户状态
     * 修改用户状态值 为0
     */
    void stopUser(Integer uid);


    /**
     * 启用用户
     */
    void startUser(Integer uid);


    /**
     * 根据id 查找对象
     */
    User findById(Integer uid);
    //统计所有活跃用户数量
    int getTotalUserConunt();
}
