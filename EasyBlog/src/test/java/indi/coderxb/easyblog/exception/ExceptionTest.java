/**
 * ExceptionTest.java   2015年7月15日 下午5:04:40 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2015 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.exception;

public class ExceptionTest {

    public void testExceptionReturn() {

        int a = 1;
        int b = 6;

        try {
            int sum = sum(a, b);
            System.out.println("sum = " + sum);
        } catch (RuntimeException e) {
            System.out.println("调的方法发生了异常");
            return;
        }

        System.out.println("计算完成");
    }

    private int sum(int a, int b) {
        if (b > 3) {
            throw new RuntimeException("b不能大于3");
        }
        return a + b;
    }

    public static void main(String[] args) {
        ExceptionTest tt = new ExceptionTest();
        tt.testExceptionReturn();
    }
}
