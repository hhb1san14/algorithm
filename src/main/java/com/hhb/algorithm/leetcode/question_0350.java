package com.hhb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @description: 350. 两个数组的交集 II https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @author: huanghongbo
 * @date: 2021-09-16 15:24
 **/
public class question_0350 {
    //双指针
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        int[] arr = new int[nums1.length + nums2.length];
        int index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                arr[index++] = nums1[index1];
                index1++;
                index2++;
            } else if (nums1[index1] <= nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }
}
