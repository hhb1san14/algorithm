package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @author hhb
 * @date 2022/6/15
 * @description42. 接雨水 https://leetcode.cn/problems/trapping-rain-water/
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class question_0042 {

    /**
     * 暴力破解
     * 从第二个柱子开始计算到倒数第二个柱子，就是能防水的柱子
     * 当前这个柱子能放的水，取决当前柱子的左边的最大与右面的最大，
     * I
     * I     I
     * I   I I
     * I I I I
     * 假设上面是四个柱子，那么第二个柱子能装多少水，取决于左边最大的柱子和右边最大的柱子中的最小值
     * 及第一根和第四根，min(4,3),计算出两边大小后，还要减去自己当前柱子的高度，
     * 2 = min(4-3) -1,所以第二个柱子，能放2个水的高度
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int result = 0;
        int size = height.length;
        // 从第二个柱子开始遍历，遍历到倒数第二个柱子，以为首位不管高度如何，都无法存水
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            // 计算出当前这个柱子左边的最大高度
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            //计算当前这个柱子右边的最大高度
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            // 取两个高度的最小值（短板） - 当前柱子的高度，就是当前这个柱子能放水的空间
            result = result + Math.min(maxLeft, maxRight) - height[i];
        }
        return result;
    }

    /**
     * 单调栈，是一层一层计算的
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int result = 0;
        int curr = 0;
        int length = height.length;
        Stack<Integer> stack = new Stack<>();
        while (curr < length) {
            while (!stack.isEmpty() && height[curr] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int w = curr - stack.peek() - 1;
                int h = Math.min(height[curr], height[stack.peek()]) - height[top];
                result += w * h;
            }
            stack.push(curr);
            curr++;
        }
        return result;
    }

    /**
     * 单调栈，五毒神掌第二边
     *
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        int result = 0;
        // 用来存放索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            //判断后面的柱子比当前的柱子高时候
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int curr = stack.pop();
                // 如果栈为空，直接弹出
                if (stack.isEmpty()) {
                    break;
                }
                // 那么此时计算的计算的是 curr 前后能放多少水
                // 高度就是当前这个柱子左右的中的最小值- 当前的高度
                int h = Math.min(height[i], height[stack.peek()]) - height[curr];
                // 在计算两个柱子直接的长度
                int w = i - stack.peek() - 1;
                result += h * w;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.err.println(trap3(arr));
    }


}
