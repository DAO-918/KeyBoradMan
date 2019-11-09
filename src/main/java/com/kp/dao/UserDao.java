package com.kp.dao;


import org.springframework.stereotype.Repository;

@Repository
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
}
