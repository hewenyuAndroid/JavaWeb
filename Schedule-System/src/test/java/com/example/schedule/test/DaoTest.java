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

    @Test
    public void testInsertSchedule() {
        BaseDao baseDao = new BaseDao();
        String sql = "insert into sys_schedule values(DEFAULT, ?,?,?)";
        int count = baseDao.baseUpdate(sql, 1, "学习Java", 0);
        System.out.println("count:" + count);
    }

    @Test
    public void testDeleteSchedule() {
        BaseDao baseDao = new BaseDao();
        String sql = "delete from sys_schedule where uid = ?";
        int count = baseDao.baseUpdate(sql, 1);
        System.out.println("count:" + count);
    }


}
