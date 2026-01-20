/**
 * TestClass.java   2015年12月21日 下午5:49:46 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2015 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.other;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void testTryCatchInFor() {
        for (int i = 2; i < 10; i++) {
            try {
                if (i % 2 == 0) {
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                System.out.println("偶数抛异常 = " + i);
                continue;
            }
            System.out.println("成功完成 = " + i);
        }
    }
    public static void main(String[] args) {
        testTryCatchInFor();
        List<String> cidrList = new ArrayList<String>();
        cidrList.add("1.1.1.1/32");
        cidrList.add("1.1.1.2/31");
        cidrList.add("1.1.1.3/30");
        cidrList.add("1.1.1.4/29");
        cidrList.add("1.1.1.5/28");
        cidrList.add("1.1.1.6/27");
        cidrList.add("1.1.1.7/26");
        cidrList.add("1.1.1.8/25");
        cidrList.add("1.1.1.9/24");
        cidrList.add("1.1.1.10/23");
        cidrList.add("1.1.1.11/22");
        cidrList.add("1.1.1.12/21");
        cidrList.add("1.1.1.13/20");
        for (int i = 0; i < 6; i++) {
            if (cidrList.contains("1.1.1.1/32")) {
                cidrList.remove("1.1.1.1/32");
            }
            if (cidrList.contains("1.1.1.5/28")) {
                cidrList.remove("1.1.1.5/28");
            }
        }
        for (int i = 0; i < 6; i++) {
            if (cidrList.contains("1.1.1.10/23")) {
                cidrList.remove("1.1.1.10/23");
            }
        }
        System.out.println(cidrList.toString());
    }
}
