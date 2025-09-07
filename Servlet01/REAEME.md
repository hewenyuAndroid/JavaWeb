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
4. `load-on-startup` 中定义的正整数表示实例化顺序，如果数字重复了，容器自行解决实例化顺序问题，但是应该避免重复;
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


# 请求转发和响应重定向

- 请求转发和响应重定向是web应用中间接访问项目资源的两种手段，也是 `servlet` 控制页面跳转的两种手段;
- 请求转发通过 `HttpServletRequest` 实现，响应重定向通过 `HttpServletResponse` 实现;

## 请求转发

![请求转发](./imgs/servlet_request_zhuan_fa.png)

- 请求转发通过 `HttpServletRequest` 对象获取请求转发器实现;
- 请求转发是服务器内部的行为，对客户端是屏蔽的;
- 客户端只发送了一次请求，客户端地址栏不变;
- 服务器只产生了一对 请求/响应 对象，这一对请求和响应对象会继续传递给下一个资源;
- 因为全程只有一个 `HttpServletRequest` 对象，所以请求参数也可以传递，请求域中的数据也可以传递;
- 请求转发可以转发给其它 `servlet` 动态资源，也可以转发给一些静态资源以实现页面跳转;
- 请求转发可以转发给 `WEB-INF` 下受保护的资源;
- 请求转发不能转发到本项目以外的外部资源;

![请求转发执行日志](./imgs/servlet_request_forwarder.png)

对于客户端来说，只执行了一次请求

![请求转发客户端请求](./imgs/servlet_request_forwarder_browser.png)

## 请求重定向

![请求重定向](./imgs/servlet_request_chong_ding_xiang.png)





