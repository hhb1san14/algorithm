package com.hhb.algorithm.leetcode;

import java.util.Map;
import java.util.TreeMap;

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
public class question_0082_no_perfect {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (head != null) {
            if (treeMap.containsKey(head.val)) {
                treeMap.put(head.val, treeMap.get(head.val) + 1);
            } else {
                treeMap.put(head.val, 0);
            }
            head = head.next;
        }
        ListNode temp = new ListNode(-1);
        ListNode curr = new ListNode(-1);
        temp.next = curr;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 0) {
                ListNode node = new ListNode(key);
                curr.next = node;
                curr = node;
            }
        }
        return temp.next.next;
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
