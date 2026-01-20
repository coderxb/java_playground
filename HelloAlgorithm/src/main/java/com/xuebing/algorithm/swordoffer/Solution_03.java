package com.xuebing.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by xuebing on 2017/11/29.
 */
public class Solution_03 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> data = new ArrayList<Integer>();
        while(listNode != null) {
            data.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(data);
        return data;
    }

    public static void main(String[] args) {
        Solution_03  s03 = new Solution_03();
        ListNode node = new ListNode(0);
        ListNode preNode = node;
        for (int i = 1; i < 10; i++) {
            ListNode nextNode = new ListNode(i);
            preNode.next = nextNode;
            preNode = nextNode;
        }
        ArrayList<Integer> data = s03.printListFromTailToHead(node);
        System.out.printf("Result = " + data);
    }
}
