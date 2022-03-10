package com.hhb.algorithm.leetcode;

/**
 * @description:75. 颜色分类 https://leetcode-cn.com/problems/sort-colors/
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 *  
 * @author: huanghongbo
 * @date: 2021-08-10 09:06
 **/
public class question_0075 {

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        int start = low;
        int end = high;
        int key = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= key) {
                end--;
            }
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = key;
                arr[start] = temp;
            }

            while (start < end && arr[start] <= key) {
                start++;
            }
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = key;
                arr[end] = temp;
            }
        }
        if (start > low) {
            sort(arr, low, start - 1);
        }
        if (end < high) {
            sort(arr, end + 1, high);
        }

    }


    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);


    }


}
