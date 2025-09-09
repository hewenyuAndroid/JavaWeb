package com.example.servlet.forwarder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 请求转发原始的 Servlet
 */
@WebServlet("/forwarder_source")
public class ForwarderSourceServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ForwarderSourceServlet: req:" + req.hashCode() + ", resp:" + resp.hashCode());

        // 将请求转发给 forwarder_target
        // 获取请求转发器,转发到一个动态资源
//        RequestDispatcher forwarderTarget = req.getRequestDispatcher("forwarder_target");
        // 可以转发到一个静态资源
//        RequestDispatcher forwarderTarget = req.getRequestDispatcher("a.html");
        // 可以转发到 WEB-INF 下受保护的资源
        RequestDispatcher forwarderTarget = req.getRequestDispatcher("WEB-INF/b.html");
        // 请求转发器转发请求
        forwarderTarget.forward(req, resp);

    }
}
