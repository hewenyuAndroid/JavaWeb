package com.example.schedule.dao.impl;

import com.example.schedule.dao.BaseDao;
import com.example.schedule.dao.SysUserDao;
import com.example.schedule.pojo.SysUser;
import lombok.NonNull;

import java.util.List;

public class SysUserDaoImpl implements SysUserDao {

    private BaseDao baseDao = new BaseDao();

    @Override
    public SysUser queryByUserName(String username) {
        List<SysUser> list = baseDao.baseQuery(SysUser.class, "select uid, username, user_pwd as userPwd from sys_user where username=?", username);
        return list.stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public int insertUser(@NonNull SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT, ?, ?)";
        return baseDao.baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());
    }

}
