package com.example.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet_session_a")
public class ServletSessionA extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求参数信息
        String username = req.getParameter("username");
        // 获取 session 对象 req.getSession() 执行的逻辑如下
        // 1. 判断请求中有没有一特殊的 cookie JSESESSIONID 值 ****
        //      1.1. 如果有
        //          1.1.1 根据 JSESESSIONID 找到对应的 session 对象
        //              1.1.1.1 找到了，返回对应的 session
        //              1.1.1.2 没找到，创建一个新的 session 返回，并且向 response 对象中存放一个 JSESESSIONID 的 cookie
        //      1.2. 如果没有，没找到，创建一个新的 session 返回，并且向 response 对象中存放一个 JSESESSIONID 的 cookie
        HttpSession session = req.getSession();

        // 设置当前 session 的超时时间，单位 s
        session.setMaxInactiveInterval(120);

        System.out.println("sessionId=" + session.getId());
        System.out.println("sessionIsNew=" + session.isNew());
        // 将 username 存入 session
        session.setAttribute("username", username);

        // 客户端响应信息
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("写入session数据成功");

    }

}
