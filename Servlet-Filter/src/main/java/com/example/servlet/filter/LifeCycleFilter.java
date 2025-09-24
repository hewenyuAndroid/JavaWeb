package com.example.servlet.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * Filter过滤器的生命周期
 * <p>
 * Servlet 过滤器生命周期
 * 1. 构造       构造器             项目启动时执行 (1次)
 * 2. 初始化     init()            构造函数执行完毕，执行初始化 (1次)
 * 3. 过滤       doFilter()        每次请求时，执行过滤函数 (n次)
 * 4. 销毁       destroy()         服务关闭 (1次)
 */
public class LifeCycleFilter implements Filter {

    public LifeCycleFilter() {
        System.out.println("LifeCycleFilter 构造函数");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化过滤器
        System.out.println("LifeCycleFilter init");

        // 读取配置的初始化参数
        String filterParamKey = filterConfig.getInitParameter("filterParamKey");
        System.out.println("LifeCycleFilter init, initParam:" + filterParamKey);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LifeCycleFilter doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("LifeCycleFilter destroy");
    }

}
