package com.kp.dao;

import com.kp.domain.User;
import com.kp.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
