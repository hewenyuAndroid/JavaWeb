package com.example.schedule.service.impl;

import com.example.schedule.dao.SysUserDao;
import com.example.schedule.dao.impl.SysUserDaoImpl;
import com.example.schedule.pojo.SysUser;
import com.example.schedule.service.SysUserService;
import com.example.schedule.utils.MD5Util;
import lombok.NonNull;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao = new SysUserDaoImpl();

    @Override
    public Boolean register(@NonNull SysUser sysUser) {
        SysUser dbSysUser = userDao.queryByUserName(sysUser.getUsername());
        if (dbSysUser != null) {
            return false;
        }

        // 密码加密
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        int count = userDao.insertUser(sysUser);
        return count > 0;
    }

    @Override
    public SysUser queryUserByUsername(String username) {
        return userDao.queryByUserName(username);
    }

}
