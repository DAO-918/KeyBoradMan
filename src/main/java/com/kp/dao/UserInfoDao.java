package com.kp.dao;

import com.kp.domain.UserInfo2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {

    /**
     * 根据条件查询用户
     *
     */
    List<UserInfo2> findByCoundition(UserInfo2 userInfo);


    /**
     * 查找用户资料 包含（发表文章数量）
     */
    List<UserInfo2> findUserMess();

    /**
     * 查询用户资料 包含带条件
     */
    List<UserInfo2> findUser(UserInfo2 userInfo);

    /**
     * 查询userInfo 所有资料
     */
    UserInfo2 findAll(Integer uid);
}
