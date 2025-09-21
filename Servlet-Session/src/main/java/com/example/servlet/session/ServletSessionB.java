package com.example.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet_session_b")
public class ServletSessionB extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 session 对象
        HttpSession session = req.getSession();
        System.out.println("sessionId=" + session.getId());
        System.out.println("sessionISNew=" + session.isNew());

        // 读取 session 中存储的用户名
        Object username = session.getAttribute("username");
        System.out.println("read from session, username=" + username);
    }

}
