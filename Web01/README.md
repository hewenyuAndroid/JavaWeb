
# Idea 新建 web 项目并发布

1. 创建一个空目录作为所有子 `module` 的根目录
2. 使用 `idea` 打开该目录

![使用idea打开根目录](./imgs/create_web_01_create_root_dir.png)

3. 为 `idea` 配置本地的 `tomcat`

![为 idea 配置本地的 tomcat](./imgs/create_web_02_config_tomcat_for_idea.png)

4. 配置当前项目的 `jdk`，语言版本，编译产物的输出目录

![配置项目的相关配置](./imgs/create_web_03_config_proj.png)

5. 在根目录下创建新的 `java module`

![新建java module](./imgs/create_web_04_new_java_module.png)

得到空的java项目

![空的 java module](./imgs/create_web_04_1_new_java_module.png)

6. 配置 java 项目为 java web 项目

> 1. 选中子module，搜索 `add framework support`

![add framework support](./imgs/create_web_05_1_convert_to_java_web_add_framework_support.png)

> 2. 添加 `web application` 支持，默认为 4.0 版本，由于当前tomcat版本为10+，因此需要使用更高版本的 `web application` 详见下面的步骤

![add web application 4.0](./imgs/create_web_05_2_convert_to_java_web_web4.png)

> 3. 修改项目设置，为java module 配置 tomcat10 的依赖

![添加tomcat10的项目依赖](./imgs/create_web_05_3_add_tomcat10_for_module.png)

![添加tomcat10的项目依赖效果](./imgs/create_web_05_4_add_tomcat10_for_module.png)

> 4. 重新为module 添加 `web application` 的支持，此时可以看到 `web application` 版本变为 6.0

![web application 6.0](./imgs/create_web_05_5_repeat_add_framework_support.png)

得到项目结构如下

![web项目目录](./imgs/create_web_05_6_web_dir.png)


7. 得到项目设置中的 `java module` 信息如下

![项目配置中的java module 的web信息](./imgs/create_web_06_1_java_module.png)

![项目配置中的java module 的目录信息](./imgs/create_web_06_2_java_module.png)

8. 配置 tomcat

> 1. 右上角添加编辑运行配置

![edit configurations](./imgs/create_web_07_1_edit_tomcat.png)

> 2. 新增 `tomcat server` 配置

![add tomcat server](./imgs/create_web_07_2_add_tomcat_server_local.png)

> 3. tomcat server 默认信息分析

![tomcat server info](./imgs/create_web_07_3_tomcat_default_info.png)

> 4. 添加 tomcat 部署的 artifact

![添加tomcat部署的 artifact](./imgs/create_web_07_4_deployment_add_artifact.png)

> 5. 部署信息分析

![部署信息分析](./imgs/create_web_07_5_deployment_info.png)

8. 运行tomcat

![运行tomcat](./imgs/create_web_08_1_run_tomcat.png)

访问项目

![访问 `http://127.0.0.1:8080/Web01](./imgs/create_web_08_2_open_in_browser.png)

9. 新增 `Servlet` 并访问

> 1. 新增 `HelloServlet` 类继承自 `HttpServlet`

![HelloServlet](./imgs/create_web_09_1_add_hello_servlet_java.png)

> 2. 新增 `HelloSevlet` 的 web 配置

![新增web配置](./imgs/create_web_09_2_add_web_config.png)

> 3. 访问 `http://127.0.0.1:8080/Web01/hello_servlet`

![访问Servlet](./imgs/create_web_09_3_open_in_browser.png)






