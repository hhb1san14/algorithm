package com.hhb.algorithm.leetcode;

import java.util.List;

/**
 * @author hhb
 * @date 2022/6/27
 * @description 25. K 个一组翻转链表 https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question_0025 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        //定义一个虚拟头结点
        ListNode dummy = new ListNode(-1, head);
        //pre为要反转的节点的前一个节点
        ListNode pre = dummy;
        while (true) {
            //尾节点初始化与pre一致
            ListNode tail = pre;
            // 遍历，看看剩余的节点数量满足不满足k个。
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            //反转pre 到 tail 之间的节点
            // 遍历过程如下： 假设 k = 3，
            //pre -> 1 -> 2 -> 3 -> 4 -> 5 原始节点
            //第一次遍历:
            // 1、先定义一个curr节点， curr 节点 为 pre.next ,curr = 1 -> 2 -> 3 -> 4 -> 5
            // 2、那么 next 节点 就是 curr.next,next =  2 -> 3 -> 4 -> 5
            // 3、让curr的next指向到 next的next，即 curr.next = next.next, 此时curr = 1 -> 3 -> 4 -> 5
            // 4、让 next的next指向pre.next，即next.next = pre.next;此时next = 2 -> 1 -> 3 -> 4 -> 5
            // 5、现在pre为 pre -> 1 -> 3 -> 4 -> 5,应该让 pre 指向 2，即 pre.next = next; pre : pre -> 2 -> 1 -> 3 -> 4 -> 5
            // 第二次遍历：
            // 1、此时curr节点为1 -> 3 -> 4 -> 5。
            // 2、那么 next 节点 就是 curr.next,next =  3 -> 4 -> 5
            // 3、让curr.next = next.next ,此时 curr = 1 -> 4 -> 5
            // 4、让 next.next 指向 pre.next, next = >3 -> 2 -> 1 -> 4 -> 5
            // 5、现在pre为 pre -> 2 -> 1 -> 4 -> 5,应该让 pre 指向 3，即 pre.next = next; pre : pre -3 -> 2 -> 1 -> 4 -> 5
            //遍历介绍，此时curr 为 1，那么应该让pre = 1.即 pre = curr；
            ListNode curr = pre.next, next;
            for (int i = 0; i < k - 1; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = curr;
        }
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
        reverseKGroup(listNode1, 3);

    }

}
