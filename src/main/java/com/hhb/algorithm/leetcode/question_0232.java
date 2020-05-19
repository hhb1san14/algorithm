package com.hhb.algorithm.leetcode;

import java.util.Stack;

/**
 * @author: huanghongbo
 * @Date: 2020-05-19 15:09
 * @Description: 用栈实现队列 https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * <p>
 * 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class question_0232 {

    private Stack<Integer> stackIn;

    private Stack<Integer> stackOut;

    /**
     * Initialize your data structure here.
     */
    public question_0232() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }


    public static void main(String[] args) {
        question_0232 queue = new question_0232();
        queue.push(1);
        queue.push(2);
        System.err.println(queue.peek());  // 返回 1
        System.err.println(queue.pop());   // 返回 1
        System.err.println(queue.empty()); // 返回 false

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
