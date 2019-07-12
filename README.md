# springboot 对多线程的支持

#### springboot 配置多线程需要两个注解

***

**@EnableAsync**：
在配置类中通过加@EnableAsync开启对异步任务的支持

**@Async**： 
在需要执行的方法上加@Async表明该方法是个异步方法，如果加在类级别上，则表明类所有的方法都是异步方法

* @Async所修饰的函数不要定义为static类型，这样异步调用不会生效

### 测试：
* 执行测试方法

# springboot 对ehcache缓存的支持

* 配置ehcache.xml 配置文件 
* 添加yml 配置
* 在启动类前加上@EnableCaching注解
* 实体类实现可序列化接口Serializable；由于需要实体类支持缓存中的磁盘存储，所以需要实体类实现可序列化接口
* 编写业务代码，在方法或者类上使用 缓存注解 ，具体用法子那个百度
**@CachePut(value = "user",key = "#user.id")** 
**@Cacheable(value = "user",key = "#root.args[0]")**
**@CacheEvict(value = "user")**