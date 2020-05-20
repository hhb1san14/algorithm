package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-20 20:29
 * @Description: 寻找两个正序数组的中位数 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class question_0004_no_perfect {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length + nums2.length;
        int length = i / 2 + 1;
        int[] arr = new int[length];
        int num1Index = 0;
        int num2Index = 0;
        int index = 0;
        while (length > 0) {
            if (num1Index < nums1.length && num2Index == nums2.length) {
                arr[index] = nums1[num1Index];
                num1Index++;
            }
            if (num2Index < nums2.length && num1Index == nums1.length) {
                arr[index] = nums2[num2Index];
                num2Index++;

            }
            if (num1Index < nums1.length && num2Index < nums2.length) {
                if (nums1[num1Index] < nums2[num2Index]) {
                    arr[index] = nums1[num1Index];
                    num1Index++;
                } else {
                    arr[index] = nums2[num2Index];
                    num2Index++;
                }
            }
            index++;
            length--;
        }

        if (i % 2 == 0) {
            return (double) (arr[arr.length - 1] + arr[arr.length - 2]) / (double) 2;
        } else {
            return (double) arr[arr.length - 1];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {3};
        int[] nums2 = {-2,-1};

        System.err.println(findMedianSortedArrays(nums1, nums2));


    }

}
