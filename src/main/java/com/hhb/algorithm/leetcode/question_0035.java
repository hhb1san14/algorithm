package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-11 10:06
 * @Description: 搜索插入位置 https://leetcode-cn.com/problems/search-insert-position/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 */
public class question_0035 {

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;

    }


    public static int searchInsert2(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                System.gc();
                return middle;
            }
            if (nums[middle] < target && nums[middle + 1] > target) {
                System.gc();
                return middle + 1;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        System.err.println(searchInsert2(arr, 2));
    }

}
