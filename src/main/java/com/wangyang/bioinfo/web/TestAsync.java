package com.wangyang.bioinfo.web;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wangyang
 * @date 2021/4/26
 */
@Component
public class TestAsync {
    @Async
    public void testAsync(){
        try {
            System.out.println("async before");
            Thread.sleep(2*1000);
            System.out.println("async after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
