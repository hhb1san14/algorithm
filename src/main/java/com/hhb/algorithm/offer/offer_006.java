package com.hhb.algorithm.offer;

import com.hhb.algorithm.leetcode.ListNode;

import java.util.Stack;

/**
 * @description:剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @author: huanghongbo
 * @date: 2021-06-18 11:17
 **/
public class offer_006 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        System.err.println(reversePrint(l1));


    }


    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        int i = 0;

        while (stack.size() > 0) {
            arr[i++] = stack.pop();
        }
        return arr;
    }
}
