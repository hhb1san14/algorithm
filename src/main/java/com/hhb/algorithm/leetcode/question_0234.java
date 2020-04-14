package com.hhb.algorithm.leetcode;


/**
 * @author: huanghongbo
 * @Date: 2020-04-14 14:38
 * @Description: 回文链表 https://leetcode-cn.com/problems/palindrome-linked-list/
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class question_0234 {


    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode node = new ListNode(0);

        while (head != null) {

        }


        ListNode curr = head;
        ListNode pre = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }


        return false;


    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
//        ListNode listNode4 = new ListNode(1);
//        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        boolean result = isPalindrome(listNode1);
        System.err.println(result);
    }
}
