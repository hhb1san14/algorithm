package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 155. 最小栈 https://leetcode-cn.com/problems/min-stack/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @author: huanghongbo
 * @date: 2021-07-29 14:51
 **/
public class question_0155 {

    private int minValue;

    private List<Integer> list;


    /**
     * initialize your data structure here.
     */
    public question_0155() {
        minValue = Integer.MAX_VALUE;
        list = new ArrayList<>();
    }

    /**
     * 自己的写法，使用list，但是pop的时候时间复杂度是O(n)
     * 可以考虑使用两个栈，一个来存放数据，一个来存放最小值，
     * 每向正常栈放一个数据，就想存放最小值的栈放一个数据,
     * 当栈推出一个数据的时候，最小值栈也弹出一个数据。
     * 这样所有的操作时间复杂度都是O(1)
     *
     * @param val
     */
    public void push(int val) {
        if (val < minValue) {
            minValue = val;
        }
        list.add(val);
    }

    public void pop() {
        list.remove(list.size() - 1);
        minValue = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < minValue) {
                minValue = list.get(i);
            }
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minValue;
    }


    public static void main(String[] args) {
        question_0155 stack = new question_0155();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.err.println(stack.getMin());
        stack.pop();
        System.err.println(stack.top());
        System.err.println(stack.getMin());

    }
}
