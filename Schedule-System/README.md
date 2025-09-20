[toc]

通过 idea 运行上部署项目时，tomcat不会直接将项目拷贝到 webapps 目录下，而是通过 `C:\Users\<用户名>\AppData\Local\JetBrains\IntelliJIdea<版本号>\tomcat\<项目名称>_<Tomcat版本>\` 通过链接的方式指向 idea 的编译后的产物位置，例如

`C:\Users\yanti\AppData\Local\JetBrains\IntelliJIdea2025.1\tomcat\ad205ec0-a027-4d10-bd65-d86ff136c0ef` 在其 `\conf\Catalina\localhost\Schedule_System.xml` 配置文件下，将部署的文件指向真实的目录

```xml
<Context path="/Schedule_System" docBase="D:\idea\proj\JavaWeb\Schedule-System\target\ScheduleSystem" />
```

# MVC架构模式

`MVC（Model View Controller）`是软件工程中的一种 软件架构模式，它把软件系统分为 `模型`、`视图`、`控制器` 三个基本部分。用一种业务逻辑、数据、界面显示分离的方法组织代码，将业务逻聚集到一个部件里面，在改进和个性化定制页面及用户交互的同时，不需要新编写业务逻辑。

- 模型(`M`): `Model` 模型层，具体功能如下:
    - 存放和数据库对应的实体类以及一些用于存储非数据库表完整相关的 `VO` 对象;
    - 存放一些对数据进行逻辑运算操作的一些业务处理代码;
- 视图(`V`): `View` 视图层，具体功能如下:
    - 存放一些视图文件相关的代码 `html`、`css` 等;
    - 在前后端分离的项目中，后端已经没有视图文件，该层次已经衍化成独立的前端项目;
- 控制(`C`): `Controller` 控制层，具体功能如下:
    - 接收客户端请求，获得请求数据;
    - 将准备好的数据响应给客户端;

> `MVC` 模式下项目中的常见包:

- `M`:
    1. 实体类包 (`pojo/entity/bean`)，用于存放和数据库对应的实体类以及一些 `VO` 对象;
    2. 数据库访问包 (`dao/mapper`)，用于存放对数据库不同表格 `CRUD` 方法封装的一些类;
    3. 服务包 (`service`)，用于存放对数据进行业务逻辑运算的一些类;
- `C`:
    - 控制层包 (`controller`);
- `V`:
    1. `web` 目录下的视图资源 `html`、`css`、`js`等;
    2. 前端工程化后，在后端项目中已经不存在了;


## MVC 项目 case (日程管理)

### 数据库表

创建 `schedule_system` 数据库并执行如下语句

```sql
SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- 创建日程表
DROP TABLE IF EXISTS `sys_schedule`;
CREATE TABLE `sys_schedule`
(
    `sid`       int NOT NULL AUTO_INCREMENT,
    `uid`       int NULL DEFAULT NULL,
    `title`     varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `completed` int(1) NULL DEFAULT NULL,
    PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- 创建用户表
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `uid`      int NOT NULL AUTO_INCREMENT,
    `username` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `user_pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`uid`) USING BTREE,
    UNIQUE INDEX `username` (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- 插入用户数据
INSERT INTO `sys_user`
VALUES (1, 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `sys_user`
VALUES (2, 'lisi', 'e10adc3949ba59abbe56e057f20f883e');

SET
FOREIGN_KEY_CHECKS = 1;
```
