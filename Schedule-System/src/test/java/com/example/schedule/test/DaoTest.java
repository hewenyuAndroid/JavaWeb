package com.example.schedule.test;

import com.example.schedule.dao.BaseDao;
import org.junit.Test;

public class DaoTest {

    @Test
    public void testQueryCount() {
        BaseDao baseDao = new BaseDao();
        Long count = baseDao.baseQueryObject(Long.class, "select count(*) from sys_user");
        System.out.println("count:" + count);
    }

}
