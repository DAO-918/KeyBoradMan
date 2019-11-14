package com.kp.service.impl;

import com.kp.dao.UserDao;
import com.kp.domain.User;
import com.kp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserDao userDao;

    /**
     * 禁用用户
     * @param uid
     */
    @Override
    public void stopUser(Integer uid) {
        userDao.stopUser(uid);
    }


    /**
     * 启用ID
     * @param uid
     */
    @Override
    public void startUser(Integer uid) {
        userDao.startUser(uid);
    }


    /**
     * 启用与停止用户
     * @param uid
     */
    @Override
    public void update(Integer uid){
        User user = userDao.findById(uid);
        Integer user_status = user.getUser_status();
        if(user_status == 1){
            userDao.stopUser(uid);
        }else{
            userDao.startUser(uid);
        }
    }
}
