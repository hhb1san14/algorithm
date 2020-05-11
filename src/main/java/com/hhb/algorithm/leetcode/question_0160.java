package com.hhb.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: huanghongbo
 * @Date: 2020-05-09 12:40
 * @Description:https://leetcode-cn.com/problems/intersection-of-two-linked-lists/ 相交链表
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * <p>
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 */
public class question_0160 {


    /**
     * 自己的方式，时间复杂度是O(n),但是额外消耗空间
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode headANode = headA;
        Set<ListNode> set = new HashSet<>();
        while (headANode != null) {
            set.add(headANode);
            headANode = headANode.next;
        }
        ListNode headBNode = headB;
        while (headBNode != null) {
            if (set.contains(headBNode)) {
                return headBNode;
            }
            headBNode = headBNode.next;
        }
        return null;
    }

    /**
     * 如果两个A、B链表相交，那么新的链表 A+B 与 B+A 会在相交点相遇
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/dong-hua-yan-shi-160-xiang-jiao-lian-biao-by-user7/ 动画
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode headANode = headA;
        ListNode headBNode = headB;
        while (headANode != headBNode) {
            headANode = headANode == null ? headB : headANode.next;
            headBNode = headBNode == null ? headA : headBNode.next;
        }
        return headANode;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode newHeadA = headA;
        ListNode newHeadB = headB;
        while (newHeadA != null || newHeadB != null) {
            if (newHeadA != newHeadB) {
                newHeadA = newHeadA == null ? headB : newHeadA.next;
                newHeadB = newHeadB == null ? headA : newHeadB.next;
            } else {
                return newHeadB;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode6.next = listNode7;
        listNode7.next = listNode4;
        ListNode listNode = getIntersectionNode1(listNode1, listNode6);
        System.err.println(listNode.val);
    }

}
