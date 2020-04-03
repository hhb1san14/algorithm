package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huanghongbo
 * @Date: 2020-04-02 14:44
 * @Description:合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class question_0021 {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null)
            return null;

        List<ListNode> list = new ArrayList<>();
        ListNode temp = null;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                temp = l2.next;
                l2.next = null;
                list.add(l2);
                l2 = temp;
            } else {
                temp = l1.next;
                l1.next = null;
                list.add(l1);
                l1 = temp;
            }
        }
        while (l1 != null) {
            temp = l1.next;
            l1.next = null;
            list.add(l1);
            l1 = temp;
        }

        while (l2 != null) {
            temp = l2.next;
            l2.next = null;
            list.add(l2);
            l2 = temp;
        }

        ListNode listNode = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            listNode.next = list.get(i);
            listNode = listNode.next;
        }
        return list.get(0);

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = mergeTwoLists(listNode1, listNode4);
        while (listNode != null) {
            System.err.print(listNode.val + "===>>> ");
        }
    }


}
