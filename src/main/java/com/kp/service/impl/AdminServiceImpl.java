package com.kp.service.impl;

import com.kp.dao.AdminDao;
import com.kp.domain.Admin;
import com.kp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminDao adminDao;

    /**
     * 查找所有
     * @param admin
     * @return
     */
    @Override
    public List<Admin> findAll(Admin admin) {
        List<Admin> all = adminDao.findAll(admin);
        return all;
    }


    @Override
    public int findAdminCount() {
        return adminDao.findAdminCount();
    }

    /**
     * 查找数据
     * @param admin
     */
    @Override
    public void addAdmin(Admin admin) {
        adminDao.addAdmin(admin);
    }


    /**
     * 删除管理员
     * @param uid
     */
    @Override
    public void deleteAdmin(Integer uid) {
        adminDao.deleteAdmin(uid);
    }


    @Override
    public List<Admin> loginAdmin(Admin admin) {
        return adminDao.loginAdmin(admin);
    }


    @Override
    public void updateLoginTime(Admin admin) {
        adminDao.updateLoginTime(admin);
    }
}
