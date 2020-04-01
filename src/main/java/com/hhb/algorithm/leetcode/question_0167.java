package com.hhb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huanghongbo
 * @Date: 2020-03-31 10:29
 * @Description: 两数之和 II - 输入有序数组:https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 */
public class question_0167 {

    /**
     * 自己的代码。时间复杂度O(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null && map.get(target - numbers[i]) > 0) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            }
            map.put(numbers[i], i + 1);
        }
        throw new IllegalArgumentException("Failed");
    }

    /**
     * 双指针法
     * 一张图告诉你 O(n) 的双指针解法的本质原理：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/yi-zhang-tu-gao-su-ni-on-de-shuang-zhi-zhen-jie-fa/
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            }
            if (sum < target) {
                i++;
            }
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("Failed");
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] ints = twoSum2(arr, 9);
        for (int i = 0; i < ints.length; i++) {
            System.err.println(ints[i]);

        }
    }

}
