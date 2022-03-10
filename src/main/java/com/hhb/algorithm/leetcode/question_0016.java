package com.hhb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @description:16. 最接近的三数之和 https://leetcode-cn.com/problems/3sum-closest/
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-29 08:45
 **/
public class question_0016 {

    public static int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                System.err.println(nums[i] + "\t" + nums[start] + "\t" + nums[end]);
                int value = nums[i] + nums[start] + nums[end];
                if (value == target) {
                    return value;
                }
                if (Math.abs(value - target) < min) {
                    result = nums[i] + nums[start] + nums[end];
                    min = Math.abs(nums[i] + nums[start] + nums[end] - target);
                }
                if (value > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }


    public static int threeSumClosest2(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int end = nums.length - 1;
                while (j < end) {
                    if (Math.abs(nums[i] + nums[j] + nums[end] - target) < min) {
                        result = nums[i] + nums[j] + nums[end];
                        min = Math.abs(nums[i] + nums[j] + nums[end] - target);
                    }
                    end--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        System.err.println(threeSumClosest(nums, 1));
    }


}
