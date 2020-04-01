package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-03-31 17:18
 * @Description:88. 合并两个有序数组:https://leetcode-cn.com/problems/merge-sorted-array/
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * <p>
 *  
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 */
public class question_0088 {


    /**
     * 自己测试是没有问题的，领扣的测试用例不对，时间复杂度O(n)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, length = m + n;
        int[] array = new int[length];
        for (int k = 0; k < length; k++) {
            if (i == m) {
                array[k] = nums2[j];
                j++;
                continue;
            }
            if (j == n) {
                array[k] = nums1[i];
                i++;
                continue;
            }
            if (nums1[i] >= nums2[j]) {
                array[k] = nums2[j];
                j++;
            } else {
                array[k] = nums1[i];
                i++;
            }

        }
        nums1 = array;
        for (int k = 0; k < nums1.length; k++) {
            System.err.print(nums1[k]);
        }
    }

    /**
     * 自己写的，时间复杂度O(n^2)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        int length = m + n;
        for (int i = 0; i < length; i++) {
            if (index == n) {
                continue;
            }
            if (i >= m) {
                nums1[i] = nums2[index];
                index++;
                continue;

            }
            if (nums1[i] < nums2[index]) {
                continue;
            } else {
                for (int j = length - 1; j > i; j--) {
                    nums1[j] = nums1[j - 1];
                }
                nums1[i] = nums2[index];
                index++;
                m++;
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            System.err.print(nums1[i]);
        }
    }

    /**
     * 时间复杂度O(n)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int length = m + n - 1;
        for (int i = length; i >= 0; i--) {
            if (len1 >= 0 && len2 >= 0) {
                nums1[i] = nums1[len1] < nums2[len2] ? nums2[len2--] : nums1[len1--];
                continue;
            }
            if (len1 >= 0 && len2 < 0) {
                nums1[i] = nums1[len1--];
            }
            if (len1 < 0 && len2 >= 0) {
                nums1[i] = nums2[len2--];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            System.err.print(nums1[i]);
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3, n = 3;
        int[] nums2 = {1, 2, 3};
        merge3(nums1, m, nums2, n);
    }


}
