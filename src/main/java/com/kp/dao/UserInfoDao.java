package com.kp.dao;

import com.kp.domain.User;
import com.kp.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserInfoDao {

    /**
     * 根据用户名查询相关数据
     * @param user_id
     * @return
     */
    List<UserInfo> selectById(Integer user_id);


    /**
     * 更新数据
     * @return
     */
    void updateUserInfo(UserInfo userInfo);


//    /**
//     * 根据两者的id相结合
//     * @param user_id
//     */
//    void conbineUser(int user_id);



    /**
     * 根据用户id实现关注量的增加
     *
     * @param user_id
     * @return
     */
    void addAttention(Integer user_id);


    /**
     * 根据用户id实现关注量的减少
     * @param user_id
     */
    void subAttention(Integer user_id);
}
