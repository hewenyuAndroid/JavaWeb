package com.example.servlet.luanma;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet_post_luanma")
public class ServletPostLuanMa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tomcat 10 默认以 UTF-8 为请求体的解码字符集
        // 客户端提交数据时，要是以其它字符集对请求体中的数据进行编码就会出现乱码

        // 设置请求体的解码字符集
//        req.setCharacterEncoding("GBK");

        String username = req.getParameter("username");
        String parameter = req.getParameter("password");
        System.out.println("username: " + username + ", parameter: " + parameter);
        resp.getWriter().write("接收到的 username:" + username + ", parameter:" + parameter);
    }
}
