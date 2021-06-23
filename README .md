# geekbang-stage1-work weektwo BY LLNF
## 作业
- 在 Tomcat/TomEE 环境, 编写一个Servlet程序，通过 JNDI 获取 JDBC DataSource, 能够获取到正常的 java.sql.Connection 对象即可, 输出 "获取JDBC连接成功"
## 部署
- weektwo下的maven项目
- 运行test.sql mysql文件 在META-INF/context.xml 修改 username="root" password="root"  url="jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8"
- tomcat8.5 启动
## 访问方式
- http://localhost:8080/weektwo/getConnection
- 控制台打印 '查询出来的用户名为zs' 即为访问成功