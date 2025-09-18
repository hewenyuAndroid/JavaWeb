package com.example.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 当前servlet需要处理以 /sys_schedule 开头的请求，因此需要将路径配置为 /sys_schedule/*
 * 包含:
 * 增加日程的请求  /sys_schedule/add
 * 查询日程的请求  /sys_schedule/query
 * 修改日程的请求  /sys_schedule/modify
 * 删除日程的请求  /sys_schedule/delete
 * 。。。
 */
@WebServlet("/sys_schedule/*")
public class SysScheduleController extends HttpServlet {

    private static final String METHOD_ADD = "add";
    private static final String METHOD_QUERY = "query";
    private static final String METHOD_MODIFY = "modify";
    private static final String METHOD_DELETE = "delete";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 需要判断请求时的 增/删/改/查

        String requestURI = req.getRequestURI();    // /sys_schedule/add
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];
        switch (methodName) {
            case METHOD_ADD:
                executeAdd(req, resp);
                break;
            case METHOD_QUERY:
                executeQuery(req, resp);
                break;
            case METHOD_MODIFY:
                executeModify(req, resp);
                break;
            case METHOD_DELETE:
                executeDelete(req, resp);
                break;
            default:
                throw new RuntimeException("不支持的日程处理方法, uri=" + requestURI);
        }

    }

    private void executeAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("executeAdd");
    }

    private void executeQuery(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("executeQuery");
    }

    private void executeModify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("executeModify");
    }

    private void executeDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("executeDelete");
    }


}
