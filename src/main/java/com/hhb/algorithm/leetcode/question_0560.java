package com.hhb.algorithm.leetcode;

/**
 * @description: 560. 和为K的子数组 https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * <p>
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * @author: huanghongbo
 * @date: 2021-07-30 15:44
 **/
public class question_0560 {

    /**
     * O(n^2) 时间复杂度
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            int sum = nums[i];
            if (sum == k) {
                result++;
            }
            while (j < nums.length) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
                j++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 0};
        System.err.println(subarraySum(arr, 0));
    }
}
