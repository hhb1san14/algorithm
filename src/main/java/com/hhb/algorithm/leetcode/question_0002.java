package com.hhb.algorithm.leetcode;


import java.math.BigDecimal;

/**
 * @author: huanghongbo
 * @Date: 2020-04-03 15:25
 * @Description:两数相加 https://leetcode-cn.com/problems/add-two-numbers/
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 */
public class question_0002 {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        java.math.BigDecimal result = new java.math.BigDecimal(0);
        java.math.BigDecimal i = new java.math.BigDecimal(1);
        while (l1 != null) {
            BigDecimal bigDecimal = new BigDecimal(l1.val);
            BigDecimal multiply = i.multiply(bigDecimal);
            result.add(multiply);
            l1 = l1.next;
            i = i.multiply(new java.math.BigDecimal(10));
        }
        java.math.BigDecimal j = new java.math.BigDecimal(1);
        while (l2 != null) {
            result.add(j.multiply(new java.math.BigDecimal(l2.val)));
            l2 = l2.next;
            j = j.multiply(new java.math.BigDecimal(10));
        }
        String s = String.valueOf(result);
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        for (int k = s.length() - 1; k >= 0; k--) {
            String c = String.valueOf(s.charAt(k));
            temp.next = new ListNode(Integer.valueOf(c));
            temp = temp.next;
        }
        return listNode.next;
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


        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        while (listNode != null) {
            System.err.print(listNode.val + "===>>> ");
            listNode = listNode.next;
        }

    }
}
