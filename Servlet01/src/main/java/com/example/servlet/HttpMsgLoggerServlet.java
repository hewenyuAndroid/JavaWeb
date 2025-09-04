package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * http报文内容日志输出的servlet
 */
@WebServlet("/http_msg_logger")
public class HttpMsgLoggerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求行
        System.out.println("请求行: 请求方法=" + req.getMethod());
        System.out.println("请求行: 请求协议=" + req.getScheme());
        System.out.println("请求行: 请求协议+版本号=" + req.getProtocol());

        // 是一个相对地址，标识资源在服务器中的地址，例如: /Servlet01/http_msg_logger
        System.out.println("请求行: 请求URI=" + req.getRequestURI());
        // 是一个绝对地址，告诉我们资源从何处获取，格式为: scheme://host:port/path?query#fragment
        // 例如: http://localhost:8081/Servlet01/http_msg_logger
        System.out.println("请求行: 请求URL=" + req.getRequestURL());

        // localPort: 当前应用程序所在的容器的端口
        // serverPort: 客户端请求服务器时，使用的服务器的端口(这里默认情况下和 localPort 相同，但是如果使用了代理服务器，则有可能是不一致的)
        // remotePort: 客户端请求服务器时，客户端使用的端口
        System.out.println("请求行: localPort=" + req.getLocalPort());
        System.out.println("请求行: serverPort=" + req.getServerPort());
        System.out.println("请求行: remotePort=" + req.getRemotePort());

        // 请求头
        // 获取单个请求头
        String accept = req.getHeader("Accept");
        System.out.println("请求头: 获取单个 accept=" + accept);
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();

            // 根据每个头名称，获取其对应的值（可能有多个值）
            // 注意：getHeader() 只返回第一个值，对于多值的头，使用 getHeaders()
            Enumeration<String> headers = req.getHeaders(headerName);
            StringBuilder sb = new StringBuilder();
            while (headers.hasMoreElements()) {
                String headerValue = headers.nextElement();
                if (sb.length() > 0) {
                    sb.append(" ^ ");
                }
                sb.append(headerValue);
            }
            System.out.println("请求头: 获取所有请求头 " + headerName + "=" + sb);
        }

        resp.getWriter().write("HttpMsgLoggerServlet");
    }

}
