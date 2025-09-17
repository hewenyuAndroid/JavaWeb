package com.example.schedule.dao;

import com.example.schedule.pojo.SysSchedule;

/**
 * 日程管理dao层
 */
public interface SysScheduleDao {

    /**
     * 添加一条日程记录
     *
     * @param schedule 日程数据对象
     * @return 数据库更新行数 <=0:添加失败 >0:添加成功
     */
    int addSchedule(SysSchedule schedule);

}
