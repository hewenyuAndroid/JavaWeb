package com.example.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 日程数据对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysSchedule implements Serializable {

    private Integer sid;

    private Integer uid;

    private String title;

    private Integer completed;

}
