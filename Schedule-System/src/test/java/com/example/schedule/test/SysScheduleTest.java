package com.example.schedule.test;

import com.example.schedule.dao.SysScheduleDao;
import com.example.schedule.dao.impl.SysScheduleDaoImpl;
import com.example.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class SysScheduleTest {

    private static SysScheduleDao sysScheduleDao;

    @BeforeClass
    public static void init() {
        sysScheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSysSchedule() {
        SysSchedule schedule = new SysSchedule();
        schedule.setUid(1)
                .setTitle("学习数据库")
                .setCompleted(0);
        int count = sysScheduleDao.addSchedule(schedule);
        System.out.println("testAddSysSchedule(): count=" + count);
    }

    @Test
    public void testQueryAll() {
        List<SysSchedule> list = sysScheduleDao.qureyAll();
        System.out.println("testQueryAll(): list=" + list);
    }

}
