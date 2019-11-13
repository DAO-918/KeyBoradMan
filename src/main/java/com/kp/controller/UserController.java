package com.kp.controller;


import com.kp.domain.UserInfo;
import com.kp.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/userInfo")
@ResponseBody
public class UserController {


    @Autowired(required = false)
    private UserService userService;


    @RequestMapping("/selectById")
    @ResponseBody
    public List<UserInfo> selectById(Integer user_id, HttpServletRequest req) throws UnsupportedEncodingException {
        System.out.println("表现层：selectByName方法");

        req.setCharacterEncoding("utf-8");
        user_id = Integer.valueOf(req.getParameter("user_id"));

        List<UserInfo> userInfos = userService.selectById(user_id);
        return userInfos;


    }


    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public void updateUserInfo(UserInfo userInfo, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, FileUploadException {
        System.out.println("表现层：updateUserInfo方法");
        req.setCharacterEncoding("utf-8");

        //创建磁盘工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //获取上传对象
        ServletFileUpload upload1 = new ServletFileUpload(factory);
        //通过上传对象解析请求
        List<FileItem> list = upload1.parseRequest(req);

        //创建一个map集合，为普通文本导入value值做准备
        Map<String, String> map = new HashMap<>();

        //遍历集合
        for (FileItem fileItem : list) {
            //判断是否为文件
            if (!fileItem.isFormField()) {
                //如果是文件
                //创建一个输入流
                InputStream is = fileItem.getInputStream();

                //项目部署目录新建一个上传文件夹
                String path = req.getSession().getServletContext().getRealPath("/uploadFiles/");
                File file = new File(path);

                //目录不存在
                if (!file.exists()) {
                    //新建目录
                    file.mkdirs();
                }


                //重置文件名(随机字符串+该文件名拼接成新的文件名)
                String fileName = UUID.randomUUID().toString() + "_" + fileItem.getName();
                System.out.println("fileName" + fileName);
                FileOutputStream fos = new FileOutputStream(fileName);

                //新文件所上传的路径
                String uploadFile = path + File.separator + fileName;

                System.out.println("新文件所在的路径：" + uploadFile);

                //将路径对象封装到UserInfo实体类中
                userInfo.setUser_img(uploadFile);
//
                //文件流的读写
                IOUtils.copy(is, fos);

                //关闭资源
                fos.close();
                is.close();
            } else {
                String name = fileItem.getFieldName();
                String value = fileItem.getString("utf-8");
                map.put(name, value);

                if("user_id".equals(name)) {
                    map.put(name,value);
                    userInfo.setUser_id(Integer.valueOf(value));
                }else if ("user_name".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_name(value);
                } else if ("user_email".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_email(value);
                } else if ("user_sex".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_sex(value);
                } else if ("user_phone".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_phone(value);
                } else if ("user_ex".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_ex(value);
                } else if ("user_time".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_time(value);
                } else if ("user_show".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_show(value);
                } else if ("user_blog".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_blog(value);
                } else if ("user_fans".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_fans(Integer.valueOf(value));
                } else if ("user_concern".equals(name)) {
                    map.put(name, value);
                    userInfo.setUser_concern(Integer.valueOf(value));
                }
            }
        }

        if (map.size() > 0) {
            userService.updateUserInfo(userInfo);
            resp.sendRedirect("/view/User/updateUserInfoSuccess.html");
            return;
        } else {
            resp.sendRedirect("/view/404.html");
            return;
        }

    }


    //关注和取消关注
    @RequestMapping("/addAttention")
    @ResponseBody
    public void addAttention(UserInfo userInfo, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("表现层：addAttention方法");

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

    @RequestMapping("/subAttention")
    public void subAttention(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("表现层：subAttention方法");

        req.setCharacterEncoding("utf-8");

        Integer user_id = Integer.valueOf(req.getParameter("user_id"));

        userService.subAttention(user_id);

        resp.sendRedirect("/view/User/subAttentionSuccess.html");
        return;
    }
}

