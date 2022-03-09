package com.hhb.algorithm.leetcode;

import java.util.Stack;

/**
 * @author: huanghongbo
 * @Date: 2020-05-09 13:42
 * @Description: 删除链表的倒数第N个节点 : https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 */
public class question_0019 {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        while (n > 0) {
            node = node.next;
            n--;
        }
        if (node == null) {
            return head.next;
        }
        ListNode curr = head;
        while (node.next != null) {
            curr = curr.next;
            node = node.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        } else {
            curr.next = null;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;


        ListNode listNode = removeNthFromEnd3(listNode1,1);
        while (listNode != null) {
            System.err.print(listNode.val + "===>>> ");
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (n > 0) {
            node = node.next;
            n--;
        }
        if (node == null) {
            return head.next;
        }
        ListNode curr = head;
        while (node.next != null) {
            curr = curr.next;
            node = node.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        } else {
            curr.next = null;
        }
        return head;
    }

    public static ListNode reserve(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static boolean isValid(String s) {
        Stack<String> str = new Stack<>();

        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals("{")) {
                str.add("}");
            } else if (String.valueOf(s.charAt(i)).equals("[")) {
                str.add("]");
            } else if (String.valueOf(s.charAt(i)).equals("(")) {
                str.add(")");
            } else {
                if (str.size() == 0 || !str.pop().equals(String.valueOf(s.charAt(i)))) {
                    return false;
                }
            }
        }
        return str.size() == 0;

    }

    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode fast = head;
        while (n > 0){
            fast = fast.next;
            n--;
        }
        if(fast == null){
            return head.next;
        }
        ListNode now = head;
        while (fast.next  != null){
            fast = fast.next;
            now = now.next;
        }
        if(now.next != null){
            now.next = now.next.next;
        }else {
            now.next = null;
        }
        return head;
    }


}
