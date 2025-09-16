package com.example.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 日程数据对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysSchedule implements Serializable {

    private Integer sid;

    private Integer uid;

    private String title;

    private Integer completed;

}
