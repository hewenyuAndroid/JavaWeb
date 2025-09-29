package com.example.servlet.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("MyApplicationListener: 应用域初始化了 contextInitialized(), servletContext: " + servletContext.hashCode());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("MyApplicationListener: 应用域销毁了 contextDestroyed(), servletContext: " + servletContext.hashCode());
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContext servletContext = event.getServletContext();
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("MyApplicationListener: 应用域添加了数据 attributeAdded(), servletContext: " + servletContext.hashCode() + ", key:" + name + ", value:" + value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        ServletContext servletContext = event.getServletContext();
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("MyApplicationListener: 应用域修改了数据 attributeReplaced(), servletContext: " + servletContext.hashCode() + ", key:" + name + ", value:" + value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        ServletContext servletContext = event.getServletContext();
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("MyApplicationListener: 应用域删除了数据 attributeRemoved(), servletContext: " + servletContext.hashCode() + ", key:" + name + ", value:" + value);
    }
}
