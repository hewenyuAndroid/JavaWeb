package com.example.servlet.luanma;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet_get_luanma")
public class ServletGetLuanMa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String parameter = req.getParameter("password");
        System.out.println("username: " + username + ", parameter: " + parameter);
        resp.getWriter().write("接收到的 username:" + username + ", parameter:" + parameter);
    }
}
