package com.hhb.algorithm.leetcode;

/**
 * @description:704. 二分查找 https://leetcode-cn.com/problems/binary-search/
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * @author: huanghongbo
 * @date: 2021-07-13 14:45
 **/
public class question_0704 {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int max = nums.length - 1;
        int min = 0;
        int middle = 0;
        while (max >= min) {
            // 防止数据太大越界问题
            middle = min + (max - min) / 2;
            if (nums[middle] > target) {
                max = middle - 1;
            } else if (nums[middle] < target) {
                min = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
//        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.err.println(search(arr, 9));
    }
}
