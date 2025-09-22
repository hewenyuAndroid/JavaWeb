package com.example.servlet.domain;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet_domain_b")
public class ServletDomainB extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从请求域中读取数据
        Object reqSource = req.getAttribute("source");

        // 从会话域中读取数据
        HttpSession session = req.getSession();
        Object sessionSource = session.getAttribute("source");

        // 从应用域中读取数据
        Object applicationSource = getServletContext().getAttribute("source");

        StringBuffer sb = new StringBuffer();
        sb.append("从 请求域、会话域、应用域中读取数据成功");
        sb.append("\n");
        sb.append("请求域: " + reqSource);
        sb.append("\n");
        sb.append("会话域: " + sessionSource + ", sessionJSESSIONID: " + session.getId());
        sb.append("\n");
        sb.append("应用域: " + applicationSource);

        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().write(sb.toString());
    }

}
