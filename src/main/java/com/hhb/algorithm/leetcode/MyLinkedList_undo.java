package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-15 10:16
 * @Description:设计链表 https://leetcode-cn.com/problems/design-linked-list/
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *  
 * <p>
 * 提示：
 * <p>
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
// question_0707
public class MyLinkedList_undo {

    private Node head;
    int size = 0;

    class Node {

        private int val;

        private Node next;

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
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList_undo() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > size - 1) {
            return -1;
        }
        Node temp = head;
        while (temp != null) {
            if (index == 0) {
                return temp.val;
            }
            temp = temp.next;
            index--;

        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node temp = head;
        if (temp == null) {
            head = node;
            size++;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index > size - 1) {
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }
        Node node = new Node(val);
        if (head.next == null) {
            head.next = node;
        }
        Node pre = head;
        Node curr = head.next;
        index--;
        while (index > 0) {
            pre = pre.next;
            curr = curr.next;
            index--;
        }
        node.next = curr;
        pre.next = node;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     * 1 -> 2 -> 3
     */
    public void deleteAtIndex(int index) {
        if (index > size - 1) {
            return;
        }

        if (index == 0) {
            size--;
            head = head.next;
            return;
        }
        Node curr = head.next;
        Node pre = head;
        int i = 0;
        while (i > index) {
            pre = pre.next;
            curr = curr.next;
        }
        if (curr == null) {
            pre.next = null;
        } else {
            pre.next = curr.next;
        }
        size--;
    }

    /**
     * ["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
     * [[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]
     *
     * @param args
     */
    public static void main(String[] args) {
        MyLinkedList_undo linkedList = new MyLinkedList_undo();
        linkedList.addAtHead(4);
        linkedList.get(1);
        linkedList.addAtHead(1);
        linkedList.addAtHead(5);
        linkedList.deleteAtIndex(3);
        linkedList.addAtHead(7);
        linkedList.get(3);
        linkedList.get(3);
        linkedList.get(3);
        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(4);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


