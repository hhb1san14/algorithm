package com.hhb.lc;

/**
 * @author hhb
 * @date 2022/6/9
 * @description
 */
public class question_0004 {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] arr = new int[length1 + length2];
        int index1 = 0, index2 = 0, index = 0;
        int length = length1 + length2;
        while (index < length) {
            if (index1 == length1 && nums1[index1] < nums2[index2]) {
                arr[index++] = nums2[index2++];
            }
            if (index2 == length2 && nums1[index1] > nums2[index2]) {
                arr[index++] = nums1[index1++];
            }


        }
        return 0;
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }


}
