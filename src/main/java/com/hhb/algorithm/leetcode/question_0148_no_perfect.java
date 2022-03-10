package com.hhb.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:148. 排序链表 https://leetcode-cn.com/problems/sort-list/
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * @author: huanghongbo
 * @date: 2021-09-03 16:25
 **/
public class question_0148_no_perfect {

    // 利用优先队列
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        while (head != null) {
            queue.offer(head.val);
            head = head.next;
        }
        ListNode temp = new ListNode(-1);
        ListNode curr = new ListNode(-1);
        temp.next = curr;
        while (!queue.isEmpty()) {
            ListNode node = new ListNode(queue.poll());
            curr.next = node;
            curr = curr.next;
        }
        return temp.next.next;
    }


}
