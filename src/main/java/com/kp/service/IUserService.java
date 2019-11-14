package com.kp.service;

public interface IUserService {

    /**
     *
     * 禁用用户状态
     * 修改用户状态值 为0
     */
    void stopUser(Integer uid);


    /**
     * 启用用户
     * 修改用户状态值为 1
     */
    void startUser(Integer uid);


    /**
     * 启用与 停止 用户状态
     */
    void update(Integer uid);



}
