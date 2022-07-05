package com.hhb.algorithm.leetcode;

/**
 * @author hhb
 * @date 2022/7/5
 * @description641. 设计循环双端队列 https://leetcode.cn/problems/design-circular-deque/
 * 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * 输出
 * [null, true, true, true, false, 2, true, true, true, 4]
 * <p>
 * 解释
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull  调用次数不大于 2000 次
 */
public class question_0641 {

    private int[] arr;
    private int left;
    private int right;
    private int size;
    private int length;

    public question_0641(int k) {
        arr = new int[k];
        left = 0;
        right = left + 1;
        size = 0;
        length = k;
    }

    public boolean insertFront(int value) {
        if (length == size) {
            return false;
        }
        arr[left] = value;
        if (left == 0) {
            left = length - 1;
        } else {
            left--;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (length == size) {
            return false;
        }
        arr[right] = value;
        if (right == length - 1) {
            right = 0;
        } else {
            right++;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        if (left == length - 1) {
            left = 0;
        } else {
            left++;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (right == 0) {
            right = length - 1;
        } else {
            right--;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }
        if (left == length - 1) {
            return arr[0];
        } else {
            return arr[left + 1];
        }
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }
        if (right == 0) {
            return arr[length - 1];
        } else {
            return arr[right - 1];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == length;
    }


    public static void main(String[] args) {
//        question_0641 circularDeque = new question_0641(3); // 设置容量大小为3
//        circularDeque.insertLast(1);                    // 返回 true
//        circularDeque.insertLast(2);                    // 返回 true
//        circularDeque.insertFront(3);                    // 返回 true
//        circularDeque.insertFront(4);                    // 已经满了，返回 false
//        circularDeque.getRear();                // 返回 2
//        circularDeque.isFull();                        // 返回 true
//        circularDeque.deleteLast();                    // 返回 true
//        circularDeque.insertFront(4);                    // 返回 true
//        circularDeque.getFront();                // 返回 4
//["MyCircularDeque",
//                "insertFront",
//                "getFront",
//                "isEmpty",
//                "deleteFront",
//                "insertLast",
//                "getRear",
//                "insertLast",
//                "insertFront",
//                "deleteLast",
//                "insertLast",
//                "isEmpty"]
//[[8],[5],[],[],[],[3],[],[7],[7],[],[4],[]]
        question_0641 circularDeque = new question_0641(8);
        System.err.println(circularDeque.insertFront(5));
        System.err.println(circularDeque.getFront());
        System.err.println(circularDeque.isEmpty());
        System.err.println(circularDeque.deleteFront());
        System.err.println(circularDeque.insertLast(3));
        System.err.println(circularDeque.getRear());
        System.err.println(circularDeque.insertLast(7));
        System.err.println(circularDeque.insertFront(7));
        System.err.println(circularDeque.deleteLast());
        System.err.println(circularDeque.insertLast(4));
        System.err.println(circularDeque.isEmpty());
    }
}
