package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-18 09:31
 * @Description: 二分查找 https://leetcode-cn.com/problems/binary-search/
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
 */
public class question_0704 {

    public static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int max = nums.length - 1;
        int min = 0;
        int middle = 0;
        while (max >= min) {
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


    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.err.println(search2(arr, 9));
    }

}
