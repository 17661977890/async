package com.example.async.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 多个线程等待
 * @Author 彬
 * @Date 2019/7/25
 */
public class TestDemo02 {

    static CountDownLatch c = new CountDownLatch(3);

    static class T1 extends Thread{
        @Override
        public void run() {
            try {
                System.out.println("等待task线程们读取完表格数据。。。。"+Thread.currentThread());
                //这里阻塞当前线程，等c=0 下面的Task线程任务结束后
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("所有表格数据读取完了，准备开始处理"+Thread.currentThread());
        }
    }

    static class Task extends Thread{
        @Override
        public void run() {
            System.out.println("线程："+Thread.currentThread()+": 开始读取负责部分的表格数据");
            //处理完减1
            c.countDown();
        }
    }

    public static void main(String[] args) {
        new T1().start();
        //多线程读取表格
        for (int i = 0; i < 3; i++) {
            new Task().start();
        }
    }
}
