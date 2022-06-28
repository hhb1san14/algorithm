package com.hhb.algorithm.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author hhb
 * @date 2022/3/1
 * @description189. 轮转数组https://leetcode-cn.com/problems/rotate-array/
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *  
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question_0189 {

    public static void rotate(int[] nums, int k) {
        int result = k % nums.length;
        reversal(nums, 0, nums.length - 1);
        reversal(nums, 0, result - 1);
        reversal(nums, result, nums.length - 1);
    }

    private static void reversal(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] arr1 = new int[k];
        int[] arr2 = new int[nums.length - k];
        int left = 0;
        for (int i = 0; i < nums.length - k; i++) {
            arr2[i] = nums[i];
        }
        for (int i = nums.length - k; i < nums.length; i++) {
            arr1[left++] = nums[i];
        }
        int i = 0;
        for (; i < arr1.length; i++) {
            nums[i] = arr1[i];
        }
        for (int i1 = 0; i1 < arr2.length; i1++) {
            nums[i++] = arr2[i1];
        }
        System.err.println("====");


    }

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotate2(nums, k);
    }
}
