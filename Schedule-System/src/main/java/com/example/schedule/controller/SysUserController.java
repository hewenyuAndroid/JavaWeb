package com.example.schedule.controller;

import com.example.schedule.pojo.SysUser;
import com.example.schedule.service.SysUserService;
import com.example.schedule.service.impl.SysUserServiceImpl;
import com.example.schedule.utils.MD5Util;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/sys_user/*", "/user/*"})
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();

    /**
     * 用户注册接口
     *
     * @param req
     * @param resp
     */
    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SysUser sysUser = fetchParameterFromReq(req);

        Boolean result = userService.register(sysUser);
        if (result) {
            // 注册成功
            resp.sendRedirect("/Schedule_System/registSuccess.html");
        } else {
            // 注册失败
            resp.sendRedirect("/Schedule_System/registFail.html");
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SysUser sysUser = fetchParameterFromReq(req);

        SysUser dbUser = userService.queryUserByUsername(sysUser.getUsername());
        if (dbUser == null) {
            resp.sendRedirect("/Schedule_System/loginUsernameError.html");
        } else if (!dbUser.getUserPwd().equals(MD5Util.encrypt(sysUser.getUserPwd()))) {
            resp.sendRedirect("/Schedule_System/loginUserPwdError.html");
        } else {
            resp.sendRedirect("/Schedule_System/showSchedule.html");
        }

    }

    private SysUser fetchParameterFromReq(HttpServletRequest req) {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        // 封装对象
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setUserPwd(userPwd);
        return sysUser;
    }

}
