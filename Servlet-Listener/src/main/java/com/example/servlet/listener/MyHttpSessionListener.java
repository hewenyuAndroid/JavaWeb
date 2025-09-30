package com.example.servlet.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

/**
 * HttpSession 会话域监听器
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("MyHttpSessionListener: sessionCreated() session对象创建, session:" + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("MyHttpSessionListener: sessionDestroyed() session对象销毁, session:" + session.getId());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("MyHttpSessionListener: attributeAdded() session:" + session.getId() + " name:" + name + ",value:" + value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("MyHttpSessionListener: attributeReplaced() session:" + session.getId() + " name:" + name + ",value:" + value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("MyHttpSessionListener: attributeRemoved() session:" + session.getId() + " name:" + name + ",value:" + value);
    }

}
