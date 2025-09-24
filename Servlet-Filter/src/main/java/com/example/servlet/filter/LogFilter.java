package com.example.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * 日志过滤器，记录请求的历史，打印日志到控制台
 * <p>
 * 过滤器使用步骤
 * 1. 实现 Filter 接口
 * 2. 重写过滤方法
 * 3. 配置过滤器的映射路径
 * 3.1 通过 web.xml 配置
 * 3.2 通过注解的方式配置
 */
public class LogFilter implements Filter {

    /**
     * 过滤请求和响应的方法
     * 1. 请求到达目标资源之前，先经过该方法
     * 2. 该方法有能力控制请求是否继续向后到达目标资源，也可以在该方法内直接向客户端做出响应
     * 3. 请求到达目标资源后，相应之前，还会经过该方法
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 请求到达目标资源之前
        long beginTime = System.currentTimeMillis();
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        System.out.println("接收到请求, uri:" + requestURI);


        // 继续执行请求
        filterChain.doFilter(servletRequest, servletResponse);

        // 相应之前
        long endTime = System.currentTimeMillis();
        System.out.println("完成请求处理， uri:" + requestURI + ", cost:" + (endTime - beginTime) + "ms");

    }

}
