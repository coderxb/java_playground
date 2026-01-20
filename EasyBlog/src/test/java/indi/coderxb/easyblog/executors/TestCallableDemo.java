/**
 * TestCallableDemo.java   2016年9月2日 上午11:10:37 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallableDemo {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> retList = new ArrayList<Future<String>>();
        
        for (int i = 1; i < 11; i++) {
            Future<String> future = exec.submit(new Task(i));
            retList.add(future);
        }

        for (Future<String> future : retList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用
                exec.shutdown();
            }
        }
    }
}

/**
 * 任务类
 *
 * @ClassName Task
 * @Description TODO
 *
 * @author lixuebing@kingsoft.com
 * @date 2016年9月2日 上午11:18:10
 */
class Task implements Callable<String> {

    private Integer id;

    public Task(Integer id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "call(" + id + ")方法被调用, 开始干活!!!");
        //一个模拟耗时的操作
        for (int i = 999999; i > 0; i--);

        String tdMsg = "线程" + Thread.currentThread().getName() + ", [" + id + "]已经执行...";
        if (this.id == 3 || this.id == 5) {
            throw new NullPointerException(tdMsg + ", 但已知定义抛出异常");
        }
        return Thread.currentThread().getName() + "call(" + id + ")方法任务完成";
    }

}
