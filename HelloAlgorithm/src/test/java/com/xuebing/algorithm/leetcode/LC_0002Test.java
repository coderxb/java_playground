/**
 * AddTwoNumbersTest.java   2015年5月4日 下午2:54:38 by gordon.li 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.xuebing.algorithm.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LC_0002Test {

    private LC_0002 atn = null;

    @Before
    public void setUp() {
        atn = new LC_0002();
    }

    @Test
    public void testL1Null() {
        LC_0002.ListNode l2 = new LC_0002.ListNode(9);
        LC_0002.ListNode tmp = new LC_0002.ListNode(6);
        l2.next = tmp;
        tmp.next = new LC_0002.ListNode(4);

        LC_0002.ListNode result = atn.addTwoNumbers(null, l2);
        atn.printListNodeValue(result);
        String actual = atn.getListNodeValueString(result);
        assertEquals("964", actual);
    }

    @Test
    public void testL2Null() {
        LC_0002.ListNode l1 = new LC_0002.ListNode(9);
        LC_0002.ListNode temp = new LC_0002.ListNode(4);
        l1.next = temp;
        temp.next = new LC_0002.ListNode(3);

        LC_0002.ListNode result = atn.addTwoNumbers(l1, null);
        atn.printListNodeValue(result);

        String actual = atn.getListNodeValueString(result);
        assertEquals("943", actual);
    }

    @Test
    public void testAllNull() {
        LC_0002.ListNode result = atn.addTwoNumbers(null, null);
        atn.printListNodeValue(result);

        String actual = atn.getListNodeValueString(result);
        assertEquals("0", actual);
    }

    @Test
    public void testZero() {
        LC_0002.ListNode l1 = new LC_0002.ListNode(0);
        LC_0002.ListNode l2 = new LC_0002.ListNode(0);

        LC_0002.ListNode result = atn.addTwoNumbers(l1, l2);
        atn.printListNodeValue(result);

        String actual = atn.getListNodeValueString(result);
        assertEquals("0", actual);
    }

    @Test
    public void testTwoFive() {
        LC_0002.ListNode l1 = new LC_0002.ListNode(5);
        LC_0002.ListNode l2 = new LC_0002.ListNode(5);

        LC_0002.ListNode result = atn.addTwoNumbers(l1, l2);
        atn.printListNodeValue(result);

        String actual = atn.getListNodeValueString(result);
        assertEquals("01", actual);
    }

    @Test
    public void testNormal() {
        LC_0002.ListNode l1 = new LC_0002.ListNode(9);
        LC_0002.ListNode temp = new LC_0002.ListNode(4);
        l1.next = temp;
        temp.next = new LC_0002.ListNode(3);

        LC_0002.ListNode l2 = new LC_0002.ListNode(9);
        LC_0002.ListNode tmp = new LC_0002.ListNode(6);
        l2.next = tmp;
        tmp.next = new LC_0002.ListNode(4);
        LC_0002.ListNode result = atn.addTwoNumbers(l1, l2);
        atn.printListNodeValue(result);

        String actual = atn.getListNodeValueString(result);
        assertEquals("818", actual);
    }

    @Test
    public void testNormal1() {
        LC_0002.ListNode l1 = new LC_0002.ListNode(9);

        LC_0002.ListNode l2 = new LC_0002.ListNode(9);
        LC_0002.ListNode tmp = new LC_0002.ListNode(6);
        l2.next = tmp;
        tmp.next = new LC_0002.ListNode(4);
        LC_0002.ListNode result = atn.addTwoNumbers(l1, l2);
        atn.printListNodeValue(result);

        String actual = atn.getListNodeValueString(result);
        assertEquals("874", actual);
    }

    @Test
    public void testNormal2() {
        LC_0002.ListNode l1 = new LC_0002.ListNode(9);
        LC_0002.ListNode temp = new LC_0002.ListNode(8);
        l1.next = temp;
        temp.next = new LC_0002.ListNode(9);

        LC_0002.ListNode l2 = new LC_0002.ListNode(9);
        LC_0002.ListNode tmp = new LC_0002.ListNode(6);
        l2.next = tmp;
        tmp.next = new LC_0002.ListNode(4);
        LC_0002.ListNode result = atn.addTwoNumbers(l1, l2);
        atn.printListNodeValue(result);

        String actual = atn.getListNodeValueString(result);
        assertEquals("8541", actual);
    }
}
