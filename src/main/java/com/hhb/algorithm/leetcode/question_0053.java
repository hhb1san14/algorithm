package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-18 10:00
 * @Description: c https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class question_0053_no_perfect {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (i != j) {
                    temp = temp + nums[j];
                }
                max = Math.max(max, temp);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1};
        System.err.println(maxSubArray(arr));
    }
}
