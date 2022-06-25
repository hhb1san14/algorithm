package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-04-01 16:20
 * @Description:反转链表 https://leetcode-cn.com/problems/reverse-linked-list/ 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class question_0206 {

    public static ListNode reverseList(ListNode head) {
        ListNode listNode = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = head.next;
            if (temp != null) {
                head.next = listNode;
                listNode = head;
                head = temp.next;
            }
        }
        return listNode;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            //记录一下当前节点的下一个节点，防止操作当前节点后，节点消失
            next = curr.next;
            // 将当前节点的下一个节点执行到原来的前一个节点，反转操作
            curr.next = pre;
            // 是前一个节点执行到当前节点，下次循环时，next节点在反转时，指向当前pre节点
            pre = curr;
            //将记录的下一个节点复制给当前节点，用于下一次循环。
            curr = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = reverseList2(listNode1);

        while (listNode != null) {
            System.err.print(listNode.val + " ==>> ");
            listNode = listNode.next;
        }
        System.err.print("NULL");
    }


    public static ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }

    public static ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode curr = head.next;
            head.next = pre;
            pre = head;
            head = curr;
        }
        return pre;
    }


}
