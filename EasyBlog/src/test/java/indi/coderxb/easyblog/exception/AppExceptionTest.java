/**
 * AppExceptionTest.java   2015年6月9日 下午10:57:53 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2015 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.exception;

import java.util.Arrays;
import org.junit.Test;

public class AppExceptionTest {

    @Test
    public void test() {
        methodOne();
    }

    private void methodOne() {

    }

    public int[] m() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 1;
        }
        return arr;
    }

    @Test
    public void testM() {
        int[] result = m();
        System.out.println(Arrays.toString(result));
    }
}
