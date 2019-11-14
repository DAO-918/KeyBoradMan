package com.kp.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.Msg;
import com.kp.domain.UserInfo2;
import com.kp.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {


    @Autowired
    private IUserInfoService userInfoService;


    /**
     * 带条件查找
     */
    @PostMapping("/findByCountiton")
    public Msg findByCountiton(UserInfo2 userInfo){
        List<UserInfo2> byCoundition = userInfoService.findByCoundition(userInfo);
        return Msg.sucess().add("byCoundition",byCoundition);

    }

    /**
     *查找所有信息 包含文章数量
     */
    @GetMapping("/findUserMess")
    public Msg findUserMess(Integer pageNo){
        PageHelper.startPage(pageNo,1);
        List<UserInfo2> userMess = userInfoService.findUserMess();

        PageInfo pageInfo = new PageInfo(userMess, 5);
        return Msg.sucess().add("pageInfo",pageInfo);
    }


    /**
     * 查询用户资料 包含带条件
     */
    @GetMapping("/findUser")
    public Msg findUser(Integer pageNo,UserInfo2 userInfo){
        PageHelper.startPage(pageNo,1);
        List<UserInfo2> user = userInfoService.findUser(userInfo);
        PageInfo pageInfo = new PageInfo(user, 5);
        return Msg.sucess().add("pageInfo",pageInfo);
    }

    /**
     * 查询userInfo 所有资料
     */
    @GetMapping("/findAll")
    public Msg findAll(Integer uid){
        UserInfo2 list = userInfoService.findAll(uid);
        return Msg.sucess().add("list",list);
    }
}
