package com.hhb.algorithm.leetcode;

import org.w3c.dom.ls.LSResourceResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huanghongbo
 * @Date: 2020-05-12 10:25
 * @Description:链表的中间结点 https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class question_0876 {

    /**
     * 遍历一次，借助List
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }


    /**
     * 双指针法
     *
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head) {

        ListNode pre = head, node = head;
        while (pre != null && node != null && node.next != null) {
            pre = pre.next;
            node = node.next;
            if (node != null) {
                System.err.println("333333");
                node = node.next;
            }
        }
        return pre;

    }


    /**
     * 双指针，快慢指针法，一个指针一次走一步，一个指针一次走两步，
     * 快指针走到头，慢指针走一般
     * @param head
     * @return
     */
    public static ListNode middleNode3(ListNode head) {
        ListNode pre = head, node = head;
        while (pre != null && node != null && node.next != null) {
            pre = pre.next;
            node = node.next.next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = middleNode3(listNode1);
        System.err.println(listNode.val);
    }
}
