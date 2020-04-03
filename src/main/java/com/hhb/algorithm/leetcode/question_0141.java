package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-04-03 16:50
 * @Description:环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 */
public class question_0141 {


    public static boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode listNode1 = head.next;
        if (listNode1 == null) {
            return false;
        }
        ListNode listNode2 = head.next.next;
        if (listNode2 == null) {
            return false;
        }
        while (listNode1 != null && listNode2 != null && listNode2.next != null) {
            if (listNode1.val == listNode2.val) {
                return true;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
        }
        return false;
    }


}
