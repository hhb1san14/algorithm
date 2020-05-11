package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-11 13:23
 * @Description: 移除链表元素 https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class question_0203 {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode listNode = head;
        while (listNode != null && listNode.next != null) {
            if (listNode.next.val == val) {
                listNode.next = listNode.next.next;
                continue;
            }
            listNode = listNode.next;
        }
        if (head.val == val) {
            return head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
//        ListNode listNode4 = new ListNode(3);
//        ListNode listNode5 = new ListNode(4);
//        ListNode listNode6 = new ListNode(5);
//        ListNode listNode7 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;

        ListNode node = removeElements(listNode1, 1);

        while (node != null) {
            System.err.print(node.val + "===>>");
            node = node.next;

        }
    }

}
