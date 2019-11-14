package com.kp.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.Admin;
import com.kp.domain.Msg;
import com.kp.service.AdminService;
import com.kp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping()
public class AdminController {


    @Autowired
    private AdminService adminService;


    @Autowired
    private ArticleService articleService;

    /**
     * 查找所有
     * @param admin
     * @return
     */
    @GetMapping("/admin/findAll")
    public Msg findAll(Integer pageNo,Admin admin){
        PageHelper.startPage(pageNo,4);
        List<Admin> all = adminService.findAll(admin);
        PageInfo pageInfo = new PageInfo(all);
        return Msg.sucess().add("pageInfo",pageInfo);

    }


    /**
     * 查询数据
     */
    @GetMapping("/admin/findAdminCount")
    public Msg findAdminCount(){
        int adminCount = adminService.findAdminCount();
        return Msg.sucess().add("num",adminCount);
    }


    @PutMapping("/admin/addAdmin")
    public Msg addAdmin(Admin admin){
        //if (admin==null){
        List<String> name = adminService.findName();
        int num = 0;
        for(int i = 0;i<name.size();i++){
            num = i;
        }
        String s = name.get(num);
        String[] ss = s.split("n");
        int num2 = 0;
        for(int i = 0;i<ss.length;i++){
            num2 = i;
        }
        String s1 = ss[num2];
        int i1 = Integer.parseInt(s1);
        int num3 = i1 +1;
        String adminnum = Integer.toString(num3);
        String adminName = "admin"+adminnum;

        /*StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 6; i++) {
                int a = Math.abs((new Random()).nextInt(8)+1);
                sb.append(a);
            }
         String password=sb.toString();*/

        String radom_num =""+(int)(Math.random()*999998+1);
        admin.setAdmin_login_name(adminName);
        admin.setAdmin_login_pwd(radom_num);
        //}
        adminService.addAdmin(admin);

        return Msg.sucess().add("admin",admin);
    }

    //？？？？？
    @RequestMapping("/delete/{id}")
    public void deleteId(@PathVariable("id") Integer articleId){
        System.out.println("进行删除操作");
        articleService.deleteId(articleId);
    }

    /**
     * 删除管理员
     */
    @PostMapping("/admin/deleteAdmin")
    public Msg deleteAdmin(Integer uid){
        adminService.deleteAdmin(uid);

        return Msg.sucess();
    }

    private String code;


    @PostMapping("/admin/code")
    public Msg code(){
        code = "";
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<4;i++){
            int a = Math.abs((new Random()).nextInt(9));
            sb.append(a);
        }
        code = sb.toString();
        return Msg.sucess().add("code",code);
    }

    /**
     * 管理员管理登陆
     */
    @PostMapping("/admin/loginAdmin")
    public Msg loginAdmin(HttpSession session,Admin admin, String codes)  {

        String admin_login_name = admin.getAdmin_login_name();
        String admin_login_pwd = admin.getAdmin_login_pwd();
        if(admin_login_name != null && !admin_login_name.equals("")
                && admin_login_pwd != null && !admin_login_pwd.equals("")){
            if(codes.equals(code)){
                List<Admin> admins = adminService.loginAdmin(admin);
                Integer admin_id = admins.get(0).getAdmin_id();

                if(admins.size() >0){
                    // 登陆成功 跳转页面
                    Date date = new Date();
                    String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                    //Timestamp timestamp = Timestamp.valueOf(nowTime);
                    //System.out.println(timestamp);
                    //Timestamp ts = new Timestamp(System.currentTimeMillis());
                    //date = ts;
                    Admin admin2 = new Admin();
                    admin2.setAdmin_id(admin_id);
                    admin2.setAdmin_login_date(nowTime);
                    adminService.updateLoginTime(admin2);
                Integer message = 200;
                    session.setAttribute("loginAdminSession", admin_login_name);
                    return Msg.sucess().add("message",message).add("loginAdmin",admin_login_name);
            }else{
                    Integer message = 501; //"用户名或者密码错误"
                return Msg.sucess().add("message",message);
            }
        }else{
                Integer message = 502;//"验证码错误"
                return Msg.sucess().add("message",message);
            }
        }else{
            Integer message = 503;//"用户名或密码不能为空"
            return Msg.sucess().add("message",message);
        }

    }

}
