/**
 * ThreadUtilTest.java   2015年7月13日 下午3:37:59 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2015 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;

public class ThreadUtilTest {

    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    private static int k = 1;

    @Test
    public void testThreadPrint() {
        for (int i = 0; i < 10; i++) {
            executor.submit(new Runnable(){
                @Override
                public void run() {
                    System.out.println("当前线程Id=" + Thread.currentThread().getId() + ", 调用次数" + getValue());
                }
            });
        }
    }

    public synchronized int getValue() {
        return k++;
    }
}
