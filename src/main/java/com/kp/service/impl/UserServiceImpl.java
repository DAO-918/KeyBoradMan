package com.kp.service.impl;

import com.kp.dao.UserInfoDao;
import com.kp.domain.UserInfo;
import com.kp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service("/userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> selectById(Integer user_id) {
        System.out.println("业务层：selectByName方法...");
        List<UserInfo> userInfos = userInfoDao.selectById(user_id);
        return userInfos;

    }

    @RequestMapping("/updateUserInfo")
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("业务层：updateUserInfo方法...");
        userInfoDao.updateUserInfo(userInfo);
        return;
    }

    @Override
    public void addAttention(Integer user_id) {
        System.out.println("业务层：addAttention方法...");
        userInfoDao.addAttention(user_id);

        return;
    }

    @Override
    public void subAttention(Integer user_id) {
        System.out.println("业务层：subAttention方法");
        userInfoDao.subAttention(user_id);
        return;
    }
}
