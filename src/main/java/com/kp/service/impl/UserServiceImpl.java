package com.kp.service.impl;

import com.kp.dao.UserDao;
import com.kp.domain.User;
import com.kp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = true)
    private UserDao userDao;

    @Override
    public User login(User user) {
        User login = userDao.login(user);
        if (login != null) {
            return login;
        } else {
            return null;
        }

    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public boolean findUser(User user) {
        User m = userDao.findUser(user);
        if (m == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updatePassword(User user) {
        userDao.updatePassword(user);
    }



    @Override
    public boolean findPhone(User user) {
        User m = userDao.findPhone(user);
        if (m == null) {
            return false;
        } else {
            return true;
        }
    }

}




