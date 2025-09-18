package com.example.schedule.test;

import com.example.schedule.dao.BaseDao;
import com.example.schedule.pojo.SysUser;
import org.junit.Test;

import java.util.List;

public class DaoTest {

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
