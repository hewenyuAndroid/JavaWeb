package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 用于生产cookie的servlet
 */
@WebServlet("/servlet_a")
public class ServletA extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookieUsername = new Cookie("username", "zhangsan");
        Cookie cookieAge = new Cookie("age", "20");

        Cookie cookieToken = new Cookie("token", "123");
        // 通过 Cookie.setMaxAge(expiry) 设置 cookie的持久化时间
        // expiry 的单位是秒，如果设置成 0 ，则表示将浏览器中保存的该 Cookie 删除
        cookieToken.setMaxAge(10*60);
        // 设置cookie的提交路径，表示当前 cookie 只有在请求 /servlet_session/servlet_c 这个资源的时候才会被提交
        cookieToken.setPath("/servlet_session/servlet_c");
        resp.addCookie(cookieToken);

        // 向 resp 中添加 cookie
        resp.addCookie(cookieUsername);
        resp.addCookie(cookieAge);
    }

}
