package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-04-05 23:07
 * @Description:删除排序链表中的重复元素 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 */
public class question_0083 {


    /**
     * 自己的写法
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // 创建一个临时节点
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        if (head == null) {
            return listNode.next;
        }
        //记录当前节点的下一个节点
        ListNode temp = head.next;
        while (head != null && temp != null) {
            // 当当前节点等于下一个节点的时候，将两个指针加1
            if (head.val != temp.val) {
                head = temp;
                temp = temp.next;
            } else {
                //否则后一个指针指向下一个节点
                temp = temp.next;
                //前一个指针指向后一个指针
                head.next = temp;
            }
        }
        return listNode.next;
    }


    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;

    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        ListNode listNode = deleteDuplicates2(listNode1);
        while (listNode != null) {
            System.err.print(listNode.val + "===>>> ");
            listNode = listNode.next;
        }

    }
}
