package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-04-09 18:17
 * @Description: 反转链表 II https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 */
public class question_0092 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode pre = head;
        ListNode fanPre = null;
        ListNode fanNext = null;
        ListNode newHead = null;
        int i = 1;

        while (head != null) {
            if (i < m) {
                fanPre = head;
            }
            if (i == m) {
                newHead = head;
            }
            if (i == n) {
                fanNext = head.next;
                head.next = null;
            }
            head = head.next;
            i++;
        }
        ListNode preNow = null;
        ListNode nextNow = null;
        ListNode curr = newHead;
        while (newHead != null) {
            nextNow = newHead.next;
            newHead.next = preNow;
            preNow = newHead;
            newHead = nextNow;
        }
        if (fanPre == null) {
            pre = preNow;
        } else {
            fanPre.next = preNow;
        }
        curr.next = fanNext;
        return pre;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        ListNode listNode = reverseBetween(listNode1, 1, 2);

        while (listNode != null) {
            System.err.print(listNode.val + " ==>> ");
            listNode = listNode.next;
        }
        System.err.print("NULL");
    }


}
