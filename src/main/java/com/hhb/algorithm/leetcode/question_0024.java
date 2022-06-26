package com.hhb.algorithm.leetcode;


/**
 * @author: huanghongbo
 * @Date: 2020-04-03 18:03
 * @Description:两两交换链表中的节点 https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class question_0024 {

    public static ListNode swapPairs(ListNode head) {
        ListNode node = head;
        if (head == null || head.next == null) {
            return node;
        }
        ListNode temp = null;
        if (head != null && head.next != null) {
            temp = head.next.next;
            node = head.next;
            node.next = head;
            head.next = temp;
        }
        ListNode pre = head;
        head = head.next;
        ListNode next = null;
        if (head != null) {
            next = head.next;
        }
        while (head != null && next != null) {
            temp = next.next;
            pre.next = next;
            next.next = head;
            head.next = temp;
            pre = head;
            head = temp;
            if (head != null) {
                next = head.next;
            }
        }
        return node;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = swapPairs2(listNode1);
        while (listNode != null) {
            System.err.print(listNode.val + "===>>> ");
            listNode = listNode.next;
        }

    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = head.next;
        ListNode first = head;
        ListNode second = head.next;
        ListNode curr = new ListNode(-1);
        while (first != null && second != null) {
            ListNode temp = second.next;
            curr.next = second;
            second.next = first;
            curr = first;
            first.next = temp;
            first = first.next;
            if (first != null) {
                second = first.next;
            }
        }
        return result;
    }

}
