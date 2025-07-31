# Servlet

## url-pattern

1. 精确匹配: `/hello_servlet`
2. 模糊匹配:
    - 使用 `*` 作为通配符，`*` 在哪里，哪里就是模糊的;
    - `/` 匹配全部，不包含 `jsp` 文件;
    - `/*` 匹配全部，包含 `jsp` 文件;
    - `/a/*` 匹配前缀，后缀模糊;
    - `/*.html` 匹配后缀;

## Servlet生命周期

servlet 生命周期如下

| 生命周期 | 对应方法                                                        | 执行时机        | 执行次数 |
|------|-------------------------------------------------------------|-------------|------|
| 构造对象 | 构造器                                                         | 第一次请求或则启动容器 | 1    |
| 初始化  | `init()`                                                    | 构造完毕后       | 1    | 
| 处理服务 | `service(HttpServletRequest req, HttpServletResponse resp)` | 每次请求        | 多次   |
| 销毁   | `destroy()`                                                 | 容器关闭        | 1    |


> `load-on-startup` 如果配置的是正整数则表示容器在启动时就要实例化 `servlet`，数字大小表示实例化的顺序;

1. 通过 生命周期 测试发现，`servlet` 对象在容器中是单例的;
2. 容器是可以处理并发的用户请求的，每个请求在容器中都会开启一个线程;
3. 多线程可能会使用相同的 `servlet` 对象，所以在 `servlet` 中不要轻易定义一些需要经常修改的成员变量;
4. `load-on-startup` 中定义的正整数表示实例化顺序，如果数字重复了，容器自行解决实例化顺序问题，但是应该避免重复，数字越小越先实例化;
5. `tomcat` 容器中，已经定义了一些随系统启动实例化的 `servlet`，自定义的 `servlet` 的 `load-on-startup` 尽量不要使用 `1~5`;


# `ServletConfig` 和 `ServletContext`

## `ServletConfig`

`ServletConfig` 是为 `Servlet` 提供初始配置参数的对象，每个 `Servlet` 都有自己独立且唯一的 `ServletConfig` 对象;

`Servlet` 容器会为每个 `Servlet` 实例化一个 `ServletConfig` 对象，并通过 `Servlet.init(ServletConfig config)` 生命周期回调函数传递给 `Servlet` 对象;

```java
package jakarta.servlet;

import java.util.Enumeration;

public interface ServletConfig {
    // 获取 Servlet 的名称，在 web.xml 配置文件中 <servlet-name> 标签中的名称
    String getServletName();
    // 获取 ServletContext 对象
    ServletContext getServletContext();
    // 根据名称获取 servlet 的初始化参数，在 web.xml 配置文件中 <init-params> 标签下定义的 key-value 数据对
    String getInitParameter(String var1);
    // 获取所有初始化参数名组成的 Enumeration 对象
    Enumeration<String> getInitParameterNames();
}
```


## `ServletConfig` 和 `ServletContext`

### `ServletConfig`

- `ServletConfig` 为 `Servlet` 提供初始配置参数的一种对象，每个 `Servlet` 都有自己独立唯一的 `ServletConfig` 对象;
- 容器会为每一个 `Servlet` 实例化一个 `ServletConfig` 对象，并通过 `Servlet` 生命周期的 `init(ServletConfig config)` 方法传入给 `Servlet`;

```java
public interface ServletConfig {
    // 获取 <servlet-name>HelloServlet</servlet-name> 标签中定义的 servlet 名称
    String getServletName();
    // 获取 ServletContext 对象
    ServletContext getServletContext();
    // 根据 key 获取 <init-param></init-param> 中配置的 value
    String getInitParameter(String var1);
    // 获取所有的初始化配置键值对信息，封装在 Enumeration 对象中
    Enumeration<String> getInitParameterNames();
}
```

### `ServletContext`

- `ServletContext` 对象为 `Servlet` 上下文对象;
- 容器会为每一个 `app` 创建一个独立且唯一的 `ServletContext` 对象;
- `ServletContext` 对象为所有的 `Servlet` 所共享;
- `ServletContext` 对象可以为所有的 `Servlet` 提供初始配置参数;


> 获取资源的磁盘路径 

获取项目部署目录下的 dir 目录
`getServletContext().getRealPath("dir")`

> 获取项目的上下文路径

项目的部署名称，也叫项目的上下文路径，在部署进入 `tomcat` 时所使用的路径，该路径是可能发生变化的，通过该 `api` 可以动态获取项目真实的上下文路径。

`getServletContext().getContextPath()`




