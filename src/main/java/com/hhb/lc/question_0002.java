package com.hhb.lc;

import com.hhb.algorithm.leetcode.ListNode;

/**
 * @author hhb
 * @date 2022/6/7
 * @description
 */
public class question_0002 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            int sum = val1 + val2 + temp;
            ListNode listNode = new ListNode(sum % 10);
            temp = sum / 10;
            if (head == null) {
                tail = listNode;
                head = new ListNode(temp);
                head.next = tail;
            } else {
                tail.next = listNode;
                tail = tail.next;
            }
        }
        if (temp > 0) {
            tail.next = new ListNode(temp);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
//        ListNode listNode7 = new ListNode(9);
//        ListNode listNode8 = new ListNode(9);
//        ListNode listNode9 = new ListNode(9);
//        ListNode listNode10 = new ListNode(9);
//        ListNode listNode11 = new ListNode(9);
//        ListNode listNode12 = new ListNode(9);
//        ListNode listNode13 = new ListNode(9);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;
//        listNode6.next = listNode7;
//        listNode7.next = listNode8;
//        listNode8.next = listNode9;
//        listNode9.next = listNode10;
//        listNode10.next = listNode11;
//        listNode11.next = listNode12;
//        listNode12.next = listNode13;


        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        while (listNode != null) {
            System.err.print(listNode.val + "===>>> ");
            listNode = listNode.next;
        }
    }
}
