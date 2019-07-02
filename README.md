# springboot 对多线程的支持

#### springboot 配置多线程需要两个注解

***

**@EnableAsync**：
在配置类中通过加@EnableAsync开启对异步任务的支持

**@Async**：
在需要执行的方法上加@Async表明该方法是个异步方法，如果加在类级别上，则表明类所有的方法都是异步方法

### 测试：
* 执行测试方法

