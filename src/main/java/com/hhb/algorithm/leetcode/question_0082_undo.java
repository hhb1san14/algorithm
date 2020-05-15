package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-12 14:49
 * @Description: 删除排序链表中的重复元素 II https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class question_0082_undo {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        while (head != null && head.next != null && head.val == head.next.val) {
            head = getHead(head);
        }
        ListNode pre = head;
        ListNode curr = head.next;
        ListNode next = null;
        if (curr != null) {
            next = curr.next;
        }
        while (curr != null && next != null) {
            if (curr.val != next.val) {
                pre = pre.next;
                curr = curr.next;
                next = next.next;
            } else {
                curr = curr.next;
                next = next.next;
            }


        }


        return head;
    }

    public static ListNode getHead(ListNode head) {
        while (head != null && head.next != null) {
            head = head.next;
            if (head.next == null) {
                return null;
            }
            if (head.val != head.next.val) {
                head = head.next;
                return head;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        ListNode listNode = deleteDuplicates(listNode1);
        while (listNode != null) {
            System.err.print(listNode.val + " ===>>> ");
            listNode = listNode.next;
        }
    }
}
