package com.example.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 抽取使用反射分发对应业务函数的逻辑

        String requestURI = req.getRequestURI();
        // /Schedule_System/sys_schedule/add 或 /Schedule_System/sys_schedule/modify 使用 / 分割字符串
        // 分割完成后得到 [, Schedule_System, sys_schedule, add]
        String[] split = requestURI.split("/");
        if (split.length != 4) {
            throw new ServletException("非法的uri, uri=" + requestURI);
        }
        String methodName = split[split.length - 1];

        // 使用反射执行对应得方法
        try {
            Method method = this.getClass().getDeclaredMethod(
                    methodName,
                    HttpServletRequest.class,
                    HttpServletResponse.class
            );
            method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("未实现对应的业务方法, methodName=" + methodName);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
