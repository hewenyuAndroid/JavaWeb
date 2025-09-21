package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet_b")
public class ServletB extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求头中的cookie
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            // 注意，如果请求头中没有 cookie ，则返回的 Cookie[] 为 null
            for (Cookie cookie : cookies) {
                System.out.println("cookie: " + cookie.getName() + " " + cookie.getValue());
            }
        }


    }

}
