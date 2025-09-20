package com.example.schedule.dao;

import com.example.schedule.pojo.SysUser;
import lombok.NonNull;

public interface SysUserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 查询结果
     */
    SysUser queryByUserName(String username);

    /**
     * 插入用户信息
     *
     * @param sysUser 新增的用户信息
     * @return 影响的行数
     */
    int insertUser(@NonNull SysUser sysUser);

}
