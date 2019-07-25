# springboot 对多线程的支持

### springboot 配置多线程需要两个注解

***

**@EnableAsync**：
在配置类中通过加@EnableAsync开启对异步任务的支持

**@Async**： 
在需要执行的方法上加@Async表明该方法是个异步方法，如果加在类级别上，则表明类所有的方法都是异步方法

* @Async所修饰的函数不要定义为static类型，这样异步调用不会生效

### 测试：
* 执行测试方法，调用AsyncService的异步方法


# countDownLatch的使用：

* countdownlatch 包

* 是一个非常实用的多线程控制工具类
* CountDownLatch是基于AQS实现的一个并发工具类，允许一个线程或多个线程等待其它线程操作，初始化是传入总的计数器，
* 内部都通过new Sync一个返回一个对象。当调用countDown()方法 就会吧计数器做递减，当计数器为0时，就会恢复等待的线程继续执行，计数到达零之前，await 方法会一直受阻塞。


```bash
# 可以看看源码：
    # AbstractQueuedSynchronizer ：AQS队列同步器
    # Sync 内部类（同步器），继承AQS
    private static final class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 4982264981922014374L;

        Sync(int count) {
            setState(count);
        }

        int getCount() {
            return getState();
        }

        protected int tryAcquireShared(int acquires) {
            return (getState() == 0) ? 1 : -1;
        }

        protected boolean tryReleaseShared(int releases) {
            // 死循环，自旋
            for (;;) {
                int c = getState();
                if (c == 0)
                    return false;
                int nextc = c-1;
                if (compareAndSetState(c, nextc))
                    return nextc == 0;
            }
        }
    }

    private final Sync sync;
    
    public CountDownLatch(int count) {
        if (count < 0) throw new IllegalArgumentException("count < 0");
        this.sync = new Sync(count);
    }

```


# springboot 对ehcache缓存的支持

* 配置ehcache.xml 配置文件 
* 添加yml 配置
* 在启动类前加上@EnableCaching注解
* 实体类实现可序列化接口Serializable；由于需要实体类支持缓存中的磁盘存储，所以需要实体类实现可序列化接口
* 编写业务代码，在方法或者类上使用 缓存注解 ，具体用法子那个百度
**@CachePut(value = "user",key = "#user.id")** 
**@Cacheable(value = "user",key = "#root.args[0]")**
**@CacheEvict(value = "user")**