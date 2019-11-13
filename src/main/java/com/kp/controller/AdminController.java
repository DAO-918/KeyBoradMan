package com.kp.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kp.domain.Admin;
import com.kp.domain.Msg;
import com.kp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;


    /**
     * 查找所有
     * @param admin
     * @return
     */
    @GetMapping("/findAll")
    public Msg findAll(Integer pageNo,Admin admin){
        PageHelper.startPage(pageNo,4);
        List<Admin> all = adminService.findAll(admin);
        PageInfo pageInfo = new PageInfo(all);
        return Msg.sucess().add("pageInfo",pageInfo);

    }


    /**
     * 查询数据
     */
    @GetMapping("/findAdminCount")
    public Msg findAdminCount(){
        int adminCount = adminService.findAdminCount();
        return Msg.sucess().add("num",adminCount);
    }


    @PutMapping("/addAdmin")
    public Msg addAdmin(Admin admin){
        int adminCount = adminService.findAdminCount();
        int num = adminCount + 1;
        String adminnum = num + "";
        String adminName = "admin"+ adminnum;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int a = Math.abs((new Random()).nextInt(9));// 产生0~57的随机数
//            if (a <= 9) {// 将0~9转为char的0~9
//                sb.append((char) (a + 48));
//            } else if (a < 33) {// 将10~33转为char的A~Z
//                if((a + 55) == 79 || (a + 55) == 73){
//                    sb.append((char) (a + 63));
//                }else{
//                    sb.append((char) (a + 55));
//                }
//            } else {// 将33~57转为char的a~z
//                sb.append((char) (a + 63));
//            }
            sb.append(a);
        }
        String password=sb.toString();



        admin.setAdminLoginName(adminName);
        admin.setAdminLoginPwd(password);


        adminService.addAdmin(admin);

        return Msg.sucess().add("admin",admin);
    }


    /**
     * 删除管理员
     */
    @PostMapping("/deleteAdmin")
    public Msg deleteAdmin(Integer uid){
        adminService.deleteAdmin(uid);

        return Msg.sucess();
    }

    private String code;


    @PostMapping("/code")
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


    @PostMapping("/loginAdmin")
    public Msg loginAdmin(Admin admin, String codes)  {

        String adminLoginName = admin.getAdminLoginName();
        String adminLoginPwd = admin.getAdminLoginPwd();
        if(adminLoginName != null && !adminLoginName.equals("")
                && adminLoginPwd != null && !adminLoginPwd.equals("")){
            if(codes.equals(code)){
                List<Admin> admins = adminService.loginAdmin(admin);
                Integer adminId = admins.get(0).getAdminId();

                if(admins.size() >0){
                    // 登陆成功 跳转页面
                    Date date = new Date();
//                    String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
//                    Timestamp timestamp = Timestamp.valueOf(nowTime);
//                    System.out.println(timestamp);
                    Timestamp ts = new Timestamp(System.currentTimeMillis());
                    date = ts;
                    Admin admin2 = new Admin();
                    admin2.setAdminId(adminId);
                    admin2.setAdminLoginDate(date);
                    adminService.updateLoginTime(admin2);
                Integer message = 200;
                return Msg.sucess().add("message",message);
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

    };

}
