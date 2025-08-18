package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet_02")
public class Servlet02 extends HelloServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从应用域中读取数据
        Object name = getServletContext().getAttribute("name");
        System.out.println("servlet_02 doGet: name=" + name);
        resp.getWriter().write("servlet02 doGet: 应用域 ServletContext 中读取的数据为: name=" + name);
    }
}
