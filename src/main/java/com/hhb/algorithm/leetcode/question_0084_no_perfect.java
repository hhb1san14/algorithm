package com.hhb.algorithm.leetcode;

/**
 * @author hhb
 * @date 2022/7/2
 * @description84. 柱状图中最大的矩形 https://leetcode.cn/problems/largest-rectangle-in-histogram/
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 * <p>
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class question_0084_no_perfect {

    /**
     * O(n^2),自己的暴力破解，但是超出时间限制
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                min = Math.min(heights[j], min);
                int temp = min * (j + 1 - i);
                maxValue = Math.max(maxValue, temp);
            }
        }
        return maxValue;
    }


    public static void main(String[] args) {
        int[] heights = {2, 4};
        System.err.println(largestRectangleArea(heights));
    }
}
