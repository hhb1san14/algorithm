package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-03-31 10:00
 * @Description: https://leetcode-cn.com/problems/container-with-most-water/
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * <p>
 */
public class question_0011 {

    /**
     * 暴力破解法，自己的答案，时间复杂度O(n^2)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height.length < 2) {
            throw new IllegalArgumentException("Failed");
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = height[i];
                if (height[j] < temp) {
                    temp = height[j];
                }
                int result = temp * (j - i);
                if (max < result) {
                    max = result;
                }
//              第50行代码，可以直接替换41-48行
//                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }


    /**
     * 双指针法，一个指针在头部，一个指针在尾部，面积大小取决于两个指针对应的值的最小值及两个指针之间的长度
     * 时间复杂度O(n)
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[j], height[i]) * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.err.println(maxArea2(array));
    }


}
