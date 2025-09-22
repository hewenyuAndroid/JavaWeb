package com.example.servlet.domain;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet_domain_a")
public class ServletDomainA extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向请求域中写入数据
        req.setAttribute("source", "from_request");

        // 向会话域中写入数据
        HttpSession session = req.getSession();
        session.setAttribute("source", "from_session");

        // 向应用域中写入数据
        getServletContext().setAttribute("source", "from_servlet_context");

        StringBuffer sb = new StringBuffer();
        sb.append("向 请求域、会话域、应用域中写入数据成功");
        sb.append("\n");
        sb.append("请求域: " + req.getAttribute("source"));
        sb.append("\n");
        sb.append("会话域: " + session.getAttribute("source") + ", sessionJSESSIONID: " + session.getId());
        sb.append("\n");
        sb.append("应用域: " + getServletContext().getAttribute("source"));
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().write(sb.toString());
    }

}
