package com.kp.service;

import com.kp.domain.User;

public interface UserService {


    public User login(User user);
void register(User user);
public boolean findUser(User user);
    void updatePassword(User user);

    public boolean findPhone(User user);

}