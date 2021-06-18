package com.hhb.algorithm.other;

import com.hhb.algorithm.leetcode.ListNode;

import java.util.List;

/**
 * @description:
 * @author: huanghongbo
 * @date: 2021-06-09 14:21
 **/
public class ListNodeSum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int index = 0;
        ListNode node = new ListNode(-1);
        ListNode curr = node;

        while (l1 != null || l2 != null || index != 0) {
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            int value = l1Value + l2Value + index;
            curr.next = new ListNode(value % 10);
            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            index = value / 10;
        }

        return node.next;

    }

    // [1,9,9,9,9,9,9,9,9,9]
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);

        ListNode l11 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        addTwoNumbers(l1, l11);


    }

}
