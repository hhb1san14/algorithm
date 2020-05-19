package com.hhb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huanghongbo
 * @Date: 2020-05-19 15:19
 * @Description: 用队列实现栈 https://leetcode-cn.com/problems/implement-stack-using-queues/
 * <p>
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 */
public class question_0225 {

    private Queue<Integer> queueIn;

    private Queue<Integer> queueOut;

    int result;


    /**
     * Initialize your data structure here.
     */
    public question_0225() {
        queueIn = new LinkedList<>();
        queueOut = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queueIn.add(x);
        result = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queueIn.size() > 1) {
            queueOut.add(queueIn.poll());
        }
        int result = queueIn.poll();
        while (!queueOut.isEmpty()) {
            this.result = queueOut.peek();
            queueIn.add(queueOut.poll());
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queueIn.isEmpty();
    }


    public static void main(String[] args) {
        question_0225 myStack = new question_0225();
        myStack.push(1);
        myStack.push(2);
        System.err.println(myStack.top());
        System.err.println(myStack.pop());
        System.err.println(myStack.empty());
    }
}
