package com.hhb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @description: 977. 有序数组的平方 https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *  
 * <p>
 * 进阶：
 * <p>
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-07-14 08:31
 **/
public class question_0977 {

    //自己的写法，O(N*logN),先平方后，在排序
    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (start != end) {
                nums[start] *= nums[start];
                nums[end] *= nums[end];
            } else {
                nums[start] *= nums[start];
            }
            start++;
            end--;
        }
        Arrays.sort(nums);
        return nums;
    }


    // 找到临界点0
    // 0左边的平方后，是一个单调递减的数组
    // 0右边的平方后，是一个单调递增的数组
    public static int[] sortedSquares2(int[] nums) {
        int start = 0;
        int pos = nums.length - 1, end = nums.length - 1;
        int[] result = new int[nums.length];
        while (start <= end) {
            if (nums[start] * nums[start] <= nums[end] * nums[end]) {
                result[pos] = nums[end] * nums[end];
                end--;
            } else {
                result[pos] = nums[start] * nums[start];
                start++;
            }
            pos--;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
//        int[] arr = {-7, -3, 2, 3, 11};
        System.err.println(sortedSquares2(arr));
    }


}
