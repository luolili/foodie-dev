阶段一：

第一周：

maven->root->Lifecycle->install

pdman:数据库建模tool。

外键：影响性能，数据库数据强一致性；
热更新：经常更新，导致一些数据无法更新；
耦合度：耦合度高；分表分库：难以做分表分库。

物理外键/逻辑外键。

小项目可以有外键。

找不到或无法加载主类 com.luo.Application: maven install

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})：
卡在信息: Initializing Spring DispatcherServlet 'dispatcherServlet'，
还是可以访问api.
