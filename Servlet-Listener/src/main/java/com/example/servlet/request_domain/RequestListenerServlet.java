package com.example.servlet.request_domain;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request_listener_servlet")
public class RequestListenerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("data", "这是一个请求域的value1");
        req.setAttribute("data", "这是一个请求域的value2");
        req.removeAttribute("data");
        resp.getWriter().write("RequestListenerServlet");
    }

}
