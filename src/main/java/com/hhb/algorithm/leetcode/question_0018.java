package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:18. 四数之和 https://leetcode-cn.com/problems/4sum/
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * <p>
 * <p>
 * @author: huanghongbo
 * @date: 2021-10-11 10:13
 **/
public class question_0018 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 如果数组是空，或者数组的长度小于4，说明没有结果
        if (nums == null || nums.length < 4) {
            return result;
        }
        //对数据进行排序
        Arrays.sort(nums);
        // 答题思路：初始时，i = 0，j= i+1,然后 left = j + 1，right = length - 1，
        // 当left  < right 的时候，如果 num[i] + num[j] + num[left] + num[right] > target, right --；
        // 当left  < right 的时候，如果 num[i] + num[j] + num[left] + num[right] < target, left++；
        // 当left 不小于 right 的时候。j++,当 j = length -2 的时候,i++,j = i + 1,重复上面的过程，就是定义好初始值 i 、j
        // 然后使用 left 、right 双指针进行处理。
        for (int i = 0; i < nums.length - 3; i++) {
            // 当i = 0 的时候除外，如果 当前数据 与前一个相等时候，说明数据重复，直接越过，例如 2,2,2,2,2
            // 当i = 0 的时候， 取数据2，但是当遍历+1，i = 1的时候，取数据2 与 上一次相同，直接pass
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 这个也是去重用的
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //因为数组已经从小到大排好顺序，当前累加和大于目标值，所有右指针左移
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                        //因为数组已经从小到大排好顺序，当前累加和小于目标值，所有左指针右移
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        // 等于目标值，添加到结果中
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        // left++后，判断当前值也上一个值是否相等，如果相等为重复，继续left++；
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        // right--后，判断当前期与上一个值是否相等，如果相等为重复，继续right --；
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
    }
}
