package com.kp.controller;


import com.kp.domain.UserInfo;
import com.kp.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

import static java.lang.System.out;


@Controller
@RequestMapping("/userInfo")
@ResponseBody
public class UserController {


    @Autowired(required = false)
    private UserService userService;


    @RequestMapping("/selectById")
    @ResponseBody
    public List<UserInfo> selectById(Integer user_id, HttpServletRequest req) throws IOException {
        out.println("表现层：selectByName方法");

        req.setCharacterEncoding("utf-8");
        user_id = Integer.valueOf(req.getParameter("user_id"));



        List<UserInfo> userInfos = userService.selectById(user_id);


        return userInfos;


    }


    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateUserInfo(UserInfo userInfo, HttpServletRequest req, HttpServletResponse resp, @RequestParam("file") MultipartFile user_img) throws IOException {
        out.println("表现层：updateUserInfo方法");
        req.setCharacterEncoding("utf-8");


        String user_id = req.getParameter("user_id");
        String user_name = req.getParameter("user_name");
        String user_email = req.getParameter("user_email");
        String user_sex = req.getParameter("user_sex");
        String user_phone = req.getParameter("user_phone");
        String user_ex = req.getParameter("user_ex");
        String user_time = req.getParameter("user_time");
        String user_show = req.getParameter("user_show");
        String user_blog = req.getParameter("user_blog");
        String user_fans = req.getParameter("user_fans");
        String user_concern = req.getParameter("user_concern");


        //上传位置
        String path = req.getSession().getServletContext().getRealPath("/uploadFiles/");


        File file = new File(path);


        //判断路径是否存在
        if (!file.exists()) {
            file.mkdirs();
        }


        //获取上传文件的名称
        String filename = user_img.getOriginalFilename();
        out.println(filename);

        //给文件重命名
        String uuid = UUID.randomUUID().toString().replace("-", "");

        //拼接起来组成新的文件名
        filename = uuid + "_" + filename;

        user_img.transferTo(new File(path, filename));

        //封装对象
        userInfo.setUser_img(filename);


        userInfo.setUser_id(Integer.valueOf(user_id));
        userInfo.setUser_name(user_name);
        userInfo.setUser_email(user_email);
        userInfo.setUser_sex(user_sex);
        userInfo.setUser_phone(user_phone);
        userInfo.setUser_ex(user_ex);
        userInfo.setUser_time(user_time);
        userInfo.setUser_show(user_show);
        userInfo.setUser_blog(user_blog);
        userInfo.setUser_fans(Integer.valueOf(user_fans));
        userInfo.setUser_concern(Integer.valueOf(user_concern));

        //调用service方法
        userService.updateUserInfo(userInfo);

        resp.sendRedirect("/view/User/updateUserInfoSuccess.html");

        return;
    }

    //关注和取消关注(关注量的增减）
    @RequestMapping(path = "/addAttention", method = RequestMethod.PUT)
    @ResponseBody
    public void addAttention(UserInfo userInfo, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        out.println("表现层：addAttention方法");

        req.setCharacterEncoding("utf-8");

        Integer user_id = Integer.valueOf(req.getParameter("user_id"));


        if (user_id != null) {

            userService.addAttention(user_id);

            resp.sendRedirect("/view/User/addAttentionSuccess.html");

            return;
        } else {
            resp.sendRedirect("/view/404.html");
            return;
        }

    }

    @RequestMapping(path = "/subAttention", method = RequestMethod.PUT)
    public void subAttention(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        out.println("表现层：subAttention方法");

        req.setCharacterEncoding("utf-8");

        Integer user_id = Integer.valueOf(req.getParameter("user_id"));

        userService.subAttention(user_id);

        resp.sendRedirect("/view/User/subAttentionSuccess.html");
        return;
    }
}

