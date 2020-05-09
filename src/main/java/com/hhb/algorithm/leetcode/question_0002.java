package com.hhb.algorithm.leetcode;


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


    /**
     * 大数有问题
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Long resultL1 = getValue(l1);
        Long resultL2 = getValue(l2);
        Long result = resultL1 + resultL2;
        ListNode node = new ListNode(-1);
        ListNode n = new ListNode((int) (result % 10));
        node.next = n;
        while ((result = result / 10) > 0) {
            ListNode temp = new ListNode((int) (result % 10));
            n.next = temp;
            n = temp;
        }
        return node.next;

    }

    public static Long getValue(ListNode listNode) {
        Long result = 0L;
        Long index = 1L;
        while (listNode != null) {
            result += listNode.val * index;
            index *= 10;
            listNode = listNode.next;
        }
        return result;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode(-1);
        int result = l1.val + l2.val;
        int index = result / 10;
        ListNode n = new ListNode(result % 10);
        node.next = n;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            int index1 = l1 == null ? 0 : l1.val;
            int index2 = l2 == null ? 0 : l2.val;
            result = index1 + index2 + index;
            index = result / 10;
            ListNode temp = new ListNode(result % 10);
            n.next = temp;
            n = temp;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (index > 0) {
            ListNode temp = new ListNode(index);
            n.next = temp;
        }
        return node.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(4);

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(9);
        ListNode listNode11 = new ListNode(9);
        ListNode listNode12 = new ListNode(9);
        ListNode listNode13 = new ListNode(9);

//        listNode1.next = listNode2;
//        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;


        ListNode listNode = addTwoNumbers2(listNode1, listNode4);
        while (listNode != null) {
            System.err.print(listNode.val + "===>>> ");
            listNode = listNode.next;
        }

    }
}
