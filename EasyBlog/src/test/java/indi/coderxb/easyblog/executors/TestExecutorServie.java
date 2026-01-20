/**
 * TestExecutorServie.java   2016年9月1日 下午6:11:54 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestExecutorServie {

    private static final ExecutorService pool = Executors.newFixedThreadPool(7);

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            pool.execute(new TestTask(i));
        }
        try {
            pool.awaitTermination(100L, TimeUnit.MILLISECONDS);
            pool.shutdown();
            // pool.execute(new TestTask());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class TestTask implements Runnable {

    private Integer num;

    public TestTask(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        String tdMsg = "线程" + Thread.currentThread().getName() + ", [" + num + "]已经执行...";
        if (this.num == 3 || this.num == 5) {
            throw new NullPointerException(tdMsg + ", 但已知定义抛出异常");
        }
        System.out.println(tdMsg);
    }

}