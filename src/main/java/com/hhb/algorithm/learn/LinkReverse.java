package com.hhb.algorithm.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huanghongbo
 * @Date: 2019-10-28 11:30
 * @Description:
 */
public class LinkReverse {


    public static void main(String[] args) {
        LinkReverse linkReverse = new LinkReverse();
        Node head = linkReverse.example2(linkReverse.init());
        while (head.next != null) {
            System.err.println(head.result);
            head = head.next;
        }
        System.err.println(head.result);
    }

    public Node init() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        return node1;
    }


    /**
     * 遍历的方法
     *
     * @param node
     * @return
     */
    public Node example1(Node node) {

        if (node == null || node.next == null) {
            return node;
        }

        Node pre = node;
        Node cur = node.next;
        Node temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        node.next = null;
        return pre;
    }


    /**
     * 递归
     *
     * @param node
     * @return
     */
    public Node example2(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node next = node.next;
        Node newHead = example2(next);
        next.next = node;
        node.next = null;
        return newHead;

    }


    // 1 - 2 - 3 - 4 - 5 - 6
    public Node example3(Node node) {

        Node deleteNode = new Node(4);
        if (node == null) {
            return node;
        }
        Node head = null;
        if (node.result != deleteNode.result) {
            head = node;
        } else {
            head = node.next;
        }
        while (head.next != null) {
            if (head.next.result == deleteNode.result) {
                head = head.next;
            }
            head = head.next;
        }
        return node;

    }


    /**
     * 快慢指针解决是否链表有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node fastNode = head;
        Node slowNode = head;
        if (head.next != null) {
            fastNode = head.next.next;
        } else {
            slowNode = head.next;
        }
        while (fastNode != null && fastNode.next != null) {
            if (fastNode == slowNode) {
                return true;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return false;
    }

    /**
     * 使用Map解决是否链表有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(Node head) {
        if (head == null) {
            return false;
        }
        Map<Node, Boolean> map = new HashMap<>();
        while (head.next != null) {
            if (map.get(head) != null && map.get(head) == true) {
                return true;
            } else {
                map.put(head, true);
            }
            head = head.next;
        }
        return false;
    }


    /**
     * todo：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param l1 1->1->2->4
     * @param l2 3->4
     * @return
     */
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node node = new Node(0);
        Node cur = node.next;
        while (l1 != null && l2 != null) {
            if (l1.result > l2.result) {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            } else {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }
        return node.next;

    }


    class Node {

        private Integer result;

        private Node next;

        public Node() {
        }

        public Node(Integer result) {
            this.result = result;
        }

        public Integer getResult() {
            return result;
        }

        public Node setResult(Integer result) {
            this.result = result;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "result=" + result +
                    ", next=" + next +
                    '}';
        }
    }

}
