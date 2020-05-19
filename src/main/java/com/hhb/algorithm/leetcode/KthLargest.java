package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: huanghongbo
 * @Date: 2020-05-19 17:45
 * @Description: 数据流中的第K大元素 https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * <p>
 * question_0703
 */
public class KthLargest {

    private List<Integer> list;

    private int k;


    public KthLargest(int k, int[] nums) {
        list = new ArrayList<>();
        this.k = k;
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (list.size() < k) {
            list.add(val);
        } else {
            if (list.get(0) < val) {
                list.remove(0);
                list.add(0, val);
            }
        }
        Collections.sort(list);
        return list.get(0);
    }

    /**
     * ["KthLargest","add","add","add","add","add"]
     * [[2,[0]],[-1],[1],[-2],[-4],[3]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int k = 2;
        int[] arr = {0};
        KthLargest kthLargest = new KthLargest(k, arr);
        kthLargest.add(-1);
        kthLargest.add(1);
        kthLargest.add(-2);
        kthLargest.add(-4);
        kthLargest.add(3);

    }

}
