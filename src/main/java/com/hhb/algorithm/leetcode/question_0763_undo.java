package com.hhb.algorithm.leetcode;

/**
 * @description:673. 最长递增子序列的个数 https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 * <p>
 * @author: huanghongbo
 * @date: 2021-09-20 18:11
 **/
public class question_0763_undo {


    public static int findNumberOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int maxLength = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    break;
                }
                temp++;
            }
            if (i == 0) {
                maxLength = temp;
            }
            if (temp < maxLength) {
                continue;
            } else if (temp > maxLength) {
                result = 1;
            }
            if (temp == maxLength) {
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        findNumberOfLIS(new int[]{1, 3, 5, 4, 7});

    }
}
