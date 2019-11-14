package com.kp.service.impl;

import com.kp.dao.UserInfoDao;
import com.kp.domain.UserInfo2;
import com.kp.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {


    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo2> findByCoundition(UserInfo2 userInfo) {
        return userInfoDao.findByCoundition(userInfo);
    }


    @Override
    public List<UserInfo2> findUserMess() {
        return userInfoDao.findUserMess();
    }


    @Override
    public List<UserInfo2> findUser(UserInfo2 userInfo) {
        return userInfoDao.findUser(userInfo);
    }


    @Override
    public UserInfo2 findAll(Integer uid) {
        return userInfoDao.findAll(uid);
    }
}
