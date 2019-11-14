package com.kp.controller;

import com.kp.domain.User;
import com.kp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired(required = true)
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, User user) {
        User flag = userService.login(user);

        if (flag!=null) {
            HttpSession session = request.getSession(true);
            String user_name=request.getParameter("user_name");
            session.setAttribute("user_name", user_name);
            flag.getUser_id();
            System.out.println(flag.getUser_id());
            request.getSession().setAttribute("user_id", flag.getUser_id());
            return "主页";
        }
        else {
            return "fail";

        }

    }

    @RequestMapping("/toregister")
    public String torgister() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(@RequestParam("user_name") String user_name, @RequestParam("user_password") String user_password, @RequestParam("user_phone") String user_phone) {
        User user = new User();
        user.setUser_name(user_name);
        user.setUser_password(user_password);
        user.setUser_phone(user_phone);
        user.setUser_status(1);
        userService.register(user);
        return "success2";

    }

    @RequestMapping("/reset")
    public String toreset() {
        return "reset";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(@RequestParam("user_phone") String user_phone, @RequestParam("user_password") String user_password) {
        User user = new User();
        user.setUser_phone(user_phone);
        user.setUser_password(user_password);
        user.setUser_status(1);
        userService.updatePassword(user);
        return "success3";
    }

    @RequestMapping(value = "chcekName", method = RequestMethod.POST)
    @ResponseBody
    public String checkName(User user) {
        boolean flag = userService.findUser(user);
        if (flag) {
            return "{\"msg\":\"true\"}";

        } else {

            return "{\"msg\":\"false\"}";
        }
    }

    @RequestMapping("/success")
    public String success() {
        return "login";
    }




    @RequestMapping(value = "chcekPhone", method = RequestMethod.POST)
    @ResponseBody
    public String checkPhone(User user) {
        boolean flag = userService.findPhone(user);
        if (flag) {
            return "{\"msg\":\"true\"}";

        } else {

            return "{\"msg\":\"false\"}";
        }
    }
    @RequestMapping("/shouye")
    public String shouye(){
        return "shouye";
    }
}
