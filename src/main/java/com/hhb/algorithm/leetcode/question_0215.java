package com.hhb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @description: 215. 数组中的第K个最大元素 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * @author: huanghongbo
 * @date: 2021-07-31 14:42
 **/
public class question_0215 {


    //时间复杂度 是 nlogN
    public static int findKthLargest(int[] nums, int k) {
//            Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//
//        Integer[] arr = new Integer[set.size()];
//        set.toArray(arr);
//        return arr[k - 1];
        Arrays.sort(nums);
        return nums[nums.length - k];

    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.err.println(findKthLargest(arr, 2));
    }
}
