package com.example.schedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * 登录校验过滤器
 */
@WebFilter(urlPatterns = {"/showSchedule.html", "/sys_schedule/*"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");
        if (user == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/schedule_system/login.html");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

}
