package com.hhb.algorithm.leetcode;

/**
 * @description:34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * @author: huanghongbo
 * @date: 2021-08-02 08:52
 **/
public class question_0034 {

    public static int[] searchRange(int[] nums, int target) {
        int left = -1;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && left == -1) {
                left = i;
            }
            if (nums[i] == target) {
                right = i;
            }
        }
        return new int[]{
                left, right
        };
    }


    //二分查找法
    public static int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == target && nums[right] == target) {
                return new int[]{left, right};
            }
            if (nums[left] != target) {
                left++;
            }
            if (nums[right] != target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }


    public static int[] searchRange3(int[] nums, int target) {
        int left = binSearch(nums, target, true);
        int right = binSearch(nums, target, false) - 1;
        return new int[]{-1, -1};
    }

    private static int binSearch(int[] nums, int target, boolean flag) {


        return 0;
    }


    public static void main(String[] args) {

        System.err.println(searchRange2(new int[]{1}, 1));


    }
}

