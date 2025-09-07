package com.example.servlet.forwarder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 请求转发的目标 servlet
 */
@WebServlet("/forwarder_target")
public class ForwarderTargetServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ForwarderTargetServlet: req:" + req.hashCode() + ", resp:" + resp.hashCode());

        resp.getWriter().write("from forwarder_target response.");

    }

}
