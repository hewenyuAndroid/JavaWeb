package com.example.schedule.service;

import com.example.schedule.pojo.SysUser;
import lombok.NonNull;

/**
 * 用户信息处理服务接口
 */
public interface SysUserService {


    /**
     * 注册账号
     *
     * @param sysUser 用户信息
     * @return 注册结果
     */
    Boolean register(@NonNull SysUser sysUser);

    /**
     * 登录账号
     *
     * @param username 用户账号
     * @return 数据库查询的用户信息
     */
    SysUser queryUserByUsername(String username);

}
