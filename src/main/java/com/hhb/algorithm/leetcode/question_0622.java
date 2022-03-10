package com.hhb.algorithm.leetcode;

/**
 * @description: 622. 设计循环队列
 * https://leetcode-cn.com/problems/design-circular-queue/
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *  
 * <p>
 * 示例：
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 *  
 * <p>
 * 提示：
 * <p>
 * 所有的值都在 0 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-23 14:14
 **/
public class question_0622 {

    private int[] arr;

    private int size = 0;

    private int length = 0;


    public question_0622(int k) {
        length = k;
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (size >= length) {
            return false;
        }
        arr[size++] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        int index = 0;
        while (index < size - 1) {
            arr[index] = arr[index + 1];
            index++;
        }
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }
        return arr[0];
    }

    /**
     * 从队尾获取一个元素
     *
     * @return
     */
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        int index = size - 1;
        return arr[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == length;
    }

    public static void main(String[] args) {

        question_0622 question_0622 = new question_0622(3);
        System.err.println(question_0622.enQueue(1)); // 返回 true
        System.err.println(question_0622.enQueue(2)); // 返回 true
        System.err.println(question_0622.enQueue(3)); // 返回 true
        System.err.println(question_0622.enQueue(4)); // 返回 false，队列已满
        System.err.println(question_0622.Rear()); // 返回 3
        System.err.println(question_0622.isFull()); // 返回 true
        System.err.println(question_0622.deQueue()); // 返回 true
        System.err.println(question_0622.enQueue(4)); // 返回 true
        System.err.println(question_0622.Rear()); // 返回 4


    }
}
