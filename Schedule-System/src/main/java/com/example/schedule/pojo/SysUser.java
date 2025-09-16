package com.example.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户数据对象
 * <p>
 * 1. 实体类的类名和数据库表名称应该对应 (对应不是一致)
 * 2. 实体类的属性名和数据库表中的列名应该对应
 * 3. 每个属性都必须是私有的
 * 4. 每个属性都应该具备 getter/setter
 * 5. 必须具备无参构造器
 * 6. 应该实现序列化接口 (缓存、分布式项目数据传递，可能会将数据序列化)
 * 7. 应该重写类的 hashcode 和 equals 方法
 * 8。toString 是否重写都可以
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {

    private Integer uid;

    private String username;

    private String userPwd;

}
