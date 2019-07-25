package com.example.async.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 *  1个线程的等待
 * @Author 彬
 * @Date 2019/7/25
 */
public class TestDemo01 {

    //实例化一个倒计数器，count指定计数个数 2，加static 为了可以在本来静态main方法中使用(静态方法不能直接访问外部实例成员，可以在方法内new 或者 static 变成静态成员)
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("初始化任务数："+c.getCount());
        new Thread(()->{
            System.out.println("任务1执行"+ Thread.currentThread());
            //计数减一
            c.countDown();
            System.out.println("任务2执行"+ Thread.currentThread());
            c.countDown();
        }).start();
        //等待，阻塞当前线程，当计数减少为0时，所有线程并行执行。除非线程被中断
        c.await();
        System.out.println("任务执行完毕！"+Thread.currentThread());
    }
}
