package com.example.schedule.test;

import com.example.schedule.dao.BaseDao;
import com.example.schedule.pojo.SysUser;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DaoTest {

    @Test
    public void testQuery() {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            String driverClassName = properties.getProperty("driverClassName");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from sys_user");
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                int dbUid = resultSet.getInt(1);
                String dbUsername = resultSet.getString(2);
                String dbUserPwd = resultSet.getString(3);
                SysUser sysUser = new SysUser(dbUid, dbUsername, dbUserPwd);
                System.out.println("sysUser = " + sysUser);
            }
            System.out.println("columnCount:" + columnCount);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testQueryCount() {
        BaseDao baseDao = new BaseDao();
        Long count = baseDao.baseQueryObject(Long.class, "select count(*) from sys_user");
        System.out.println("count:" + count);
    }

    @Test
    public void testQueryObj() {
        BaseDao baseDao = new BaseDao();
        // 使用别名的方式解决数据库字段 user_pwd 和 java 字段 userPwd 映射失败的问题
        List<Object> list = baseDao.baseQuery(SysUser.class, "select uid, username, user_pwd as userPwd from sys_user where uid = 1");
        System.out.println("result:" + list);
    }

}
