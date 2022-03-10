package com.hhb.algorithm.leetcode;

/**
 * @description:
 * @author: huanghongbo
 * @date: 2021-09-24 09:19
 **/
public class Node {

    public int val;

    public Node prev;

    public Node next;

    public Node child;


    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public Node setVal(int val) {
        this.val = val;
        return this;
    }

    public Node getPrev() {
        return prev;
    }

    public Node setPrev(Node prev) {
        this.prev = prev;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    public Node getChild() {
        return child;
    }

    public Node setChild(Node child) {
        this.child = child;
        return this;
    }
}
