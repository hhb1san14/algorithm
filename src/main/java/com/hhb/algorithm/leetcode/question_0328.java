package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-12 11:36
 * @Description: 奇偶链表 https://leetcode-cn.com/problems/odd-even-linked-list/
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class question_0328 {


    /**
     * 自己的笨方法
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList2(ListNode head) {
        ListNode node = new ListNode(-1);
        ListNode node2 = new ListNode(-1);
        ListNode jListNode = new ListNode(-1);
        ListNode oListNode = new ListNode(-1);
        node.next = jListNode;
        node2.next = oListNode;
        int i = 0;
        while (head != null) {
            if (i % 2 == 0) {
                ListNode temp = new ListNode(head.val);
                jListNode.next = temp;
                jListNode = jListNode.next;
            } else {
                ListNode temp = new ListNode(head.val);
                oListNode.next = temp;
                oListNode = oListNode.next;
            }
            i++;
            head = head.next;
        }
        jListNode.next = node2.next.next;
        return node.next.next;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode jListNode = head;
        ListNode oListNode = head.next;
        ListNode temp = head.next;
        while (oListNode != null && oListNode.next != null) {
            jListNode.next = oListNode.next;
            jListNode = jListNode.next;
            oListNode.next = jListNode.next;
            oListNode = oListNode.next;
        }
        jListNode.next = temp;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
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
        ListNode listNode = oddEvenList(listNode1);
        while (listNode != null) {
            System.err.print(listNode.val + " ===>>> ");
            listNode = listNode.next;
        }
    }
}
