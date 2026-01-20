package com.xuebing.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. 两数相加
 * @website https://leetcode-cn.com/problems/add-two-numbers/
 */
public class LC_0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //TODO: 待实现
        return null;
    }

    public void printListNodeValue(ListNode root) {
        if(root == null) {
            System.out.println("ListNode is empty.");
        }
        ListNode node = root;
        List<Integer> result = new ArrayList<>();
        while (node != null) {
            result.add(node.val);
        }
        System.out.println("Result = " + result.toString());
    }

    public String getListNodeValueString(ListNode node) {
        return null;
    }
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
