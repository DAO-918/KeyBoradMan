package com.kp.controller;


import com.kp.domain.Msg;
import com.kp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;


    /**
     * 禁用用户
     */
    @PutMapping("/stopUser")
    public Msg stopUser(Integer uid){

        userService.stopUser(uid);

        return Msg.sucess();
    }


    /**
     * 启用用户
     */
    @PutMapping("/startUser")
    public Msg startUser(Integer uid){
        userService.startUser(uid);
        return Msg.sucess();
    }



    @PostMapping("/update")
    public Msg update(Integer uid){
        userService.update(uid);
        return Msg.sucess();
    }
}
