package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/http_resp_msg_logger")
public class HttpResponseMsgLoggerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置相应行相关的api  http/1.1 200/404/500
//        resp.setStatus(404);    // 请求成功，但是强制把状态码设置成 404

        // 设置响应头
        resp.setHeader("aaa", "bbb");
//        resp.setHeader("Content-Type", "text/plain");
        resp.setContentType("text/plain");  // content-type 可以使用专门的方法设置

        // 设置响应体内容，输入文本字符输出流
        resp.getWriter().write("do http_resp_msg_logger get success.");

        // 获取二进制输出流，可以返回文件
//        ServletOutputStream outputStream = resp.getOutputStream();

    }

}
