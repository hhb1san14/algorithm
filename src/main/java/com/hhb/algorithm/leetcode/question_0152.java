package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-18 09:44
 * @Description: 乘积最大子数组 https://leetcode-cn.com/problems/maximum-product-subarray/
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class question_0152 {

    public static int maxProduct(int[] nums) {


        int max = nums[0];
        int i = nums.length;
        if()



        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (max)

            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.err.println(maxProduct(arr));
    }
}
