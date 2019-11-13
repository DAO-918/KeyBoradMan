package com.kp.dao;

import com.kp.domain.User;
import com.kp.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.zip.Inflater;

@Repository
public interface UserInfoDao {

    /**
     * 根据条件查询用户
     *
     */
    List<UserInfo> findByCoundition(UserInfo userInfo);


    /**
     * 查找用户资料 包含（发表文章数量）
     */
    List<UserInfo> findUserMess();

    /**
     * 查询用户资料 包含带条件
     */
    List<UserInfo> findUser(UserInfo  userInfo);

    /**
     * 查询userInfo 所有资料
     */
    UserInfo findAll(Integer uid);
}
