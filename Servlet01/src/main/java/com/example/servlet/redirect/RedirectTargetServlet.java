package com.example.servlet.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 响应重定向目标servlet
 */
@WebServlet("/redirect_target")
public class RedirectTargetServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RedirectTargetServlet: uri=" + req.getRequestURI());
        System.out.println("RedirectTargetServlet: remoteAddr=" + req.getRemoteAddr());
        System.out.println("RedirectTargetServlet: remotePort=" + req.getRemotePort());

        resp.getWriter().write("Redirect target servlet.");

    }
}
