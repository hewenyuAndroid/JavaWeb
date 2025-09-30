package com.example.servlet.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 请求域监听器
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();
        ServletContext servletContext = sre.getServletContext();
        System.out.println("MyServletRequestListener requestInitialized() servletContext: " + servletContext.hashCode() + ", request:" + servletRequest.hashCode() + ", requestUri: " + servletRequest.getRequestURI());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();
        ServletContext servletContext = sre.getServletContext();
        System.out.println("MyServletRequestListener requestDestroyed() servletContext: " + servletContext.hashCode() + ", request:" + servletRequest.hashCode() + ", requestUri: " + servletRequest.getRequestURI());
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        HttpServletRequest request = (HttpServletRequest) srae.getServletRequest();
        ServletContext servletContext = srae.getServletContext();
        System.out.println("MyServletRequestListener attributeAdded() servletContext: " + servletContext.hashCode() + ", uri:" + request.getRequestURI() + ", name:" + srae.getName() + ", value:" + srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        HttpServletRequest request = (HttpServletRequest) srae.getServletRequest();
        ServletContext servletContext = srae.getServletContext();
        System.out.println("MyServletRequestListener attributeReplaced() servletContext: " + servletContext.hashCode() + ", uri:" + request.getRequestURI() + ", name:" + srae.getName() + ", value:" + srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        HttpServletRequest request = (HttpServletRequest) srae.getServletRequest();
        ServletContext servletContext = srae.getServletContext();
        System.out.println("MyServletRequestListener attributeRemoved() servletContext: " + servletContext.hashCode() + ", uri:" + request.getRequestURI() + ", name:" + srae.getName() + ", value:" + srae.getValue());
    }

}
