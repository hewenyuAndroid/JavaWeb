package com.example.schedule.dao.impl;

import com.example.schedule.dao.BaseDao;
import com.example.schedule.dao.SysScheduleDao;
import com.example.schedule.pojo.SysSchedule;
import lombok.NonNull;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into sys_schedule values(DEFAULT, ?, ?, ?)";
        return baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
    }

    @Override
    public @NonNull List<SysSchedule> qureyAll() {
        return baseQuery(SysSchedule.class, "select * from sys_schedule");
    }

}
