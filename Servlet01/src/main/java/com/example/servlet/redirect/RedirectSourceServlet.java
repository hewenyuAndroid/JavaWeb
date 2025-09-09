package com.example.servlet.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 重定向原始的请求 servlet
 */
@WebServlet("/redirect_source")
public class RedirectSourceServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RedirectSourceServlet: uri=" + req.getRequestURI());
        System.out.println("RedirectSourceServlet: remoteAddr=" + req.getRemoteAddr());
        System.out.println("RedirectSourceServlet: remotePort=" + req.getRemotePort());

        // 重定向到一个动态资源
//        resp.sendRedirect("redirect_target");
        // 重定向可以跳转到一个静态资源
//        resp.sendRedirect("a.html");
        // 重定向可以跳转到项目以外的资源
        resp.sendRedirect("https://www.baidu.com");
    }

}
