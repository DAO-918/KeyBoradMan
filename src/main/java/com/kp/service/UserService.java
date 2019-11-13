package com.kp.service;

import com.kp.domain.UserInfo;

import java.util.List;

public interface UserService {

    /**
     * 根据用户id查询相关数据
     * @param user_id
     * @return
     */
    List<UserInfo> selectById(Integer user_id);


    /**
     * 更新数据
     * @return
     */
    void  updateUserInfo(UserInfo userInfo);





    /**
     * 根据用户id实现关注量的增加
     *
     * @param user_id
     * @return
     */
    void addAttention(Integer user_id);


    /**
     * 根据用户Id实现关注量的减少
     * @param user_id
     */
    void subAttention(Integer user_id);
}
