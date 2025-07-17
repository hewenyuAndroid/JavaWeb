package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 使用注解的方式配置 servlet 信息
 */
@WebServlet(
        // 配置 Servlet 别名
        name = "MyServlet",
        // 配置 servlet 的访问路径
        urlPatterns = "/my_servlet"
)
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("my servlet get");
        resp.getWriter().write("my servlet get");
    }
}
