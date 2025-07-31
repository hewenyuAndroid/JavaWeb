package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 文件下载的servlet
 */
@WebServlet(name = "download", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 在 web 目录下创建一个 dir/a.txt 文件

        // 获取一个指向项目部署位置下的某个文件/目录的磁盘真实路径
        String dir = getServletContext().getRealPath("dir");
        System.out.println("dir=" + dir);
        FileOutputStream fos = new FileOutputStream(dir + "/a.txt");

        // 获取项目部署的上下文路径，项目的访问路径
        String contextPath = getServletContext().getContextPath();
        System.out.println("contextPath=" + contextPath);

        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=a.txt");
        byte[] buffer = new byte[1024];
        fos.write(buffer);
        fos.close();
        resp.getWriter().write(new String(buffer, StandardCharsets.UTF_8));
    }
}
