package com.example.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 需要开启多线程的方法
 */
@Service
public class AsyncService {

    @Async
    public void executeAsync1() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步任务::1");

    }

    @Async
    public void executeAsync2() {
        System.out.println("异步任务::2");
    }

}