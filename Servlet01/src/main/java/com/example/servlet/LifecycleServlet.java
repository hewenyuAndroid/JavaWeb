package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * servlet 的生命周期
 * 1. 实例化                       构造函数
 * 2. 初始化                       init
 * 3. 服务 (接收请求，处理请求)       service
 * 4. 销毁                        destroy
 */
@WebServlet("/lifecycle_servlet")
public class LifecycleServlet extends HttpServlet {

    public LifecycleServlet() {
        System.out.println("LifecycleServlet 构造函数");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("LifecycleServlet init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifecycleServlet service");
    }

    @Override
    public void destroy() {
        System.out.println("LifecycleServlet destroy");
    }

}
