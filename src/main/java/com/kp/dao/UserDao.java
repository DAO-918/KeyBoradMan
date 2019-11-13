package com.kp.dao;


import com.kp.domain.User;
import org.springframework.stereotype.Repository;

import java.util.zip.Inflater;

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


    /**
     * 根据id 查找对象
     */
    User findById(Integer uid);
}
