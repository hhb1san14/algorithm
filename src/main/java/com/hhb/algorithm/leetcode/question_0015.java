package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 15. 三数之和 https://leetcode-cn.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-25 10:37
 **/
public class question_0015 {


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 排序，从小到大
        Arrays.sort(nums);
        // 如果最小值 > 0，那么相加就不会出现等于0 的情况
        if (nums[0] > 0) {
            return result;
        }
        // 遍历，一次取出
        for (int i = 0; i < nums.length; i++) {
            // 如果当前取出的数 和 上一个数据是一样的，直接继续执行
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 利用双指针，第一个指针为当前数据的下一个，然后从左向右遍历
            int start = i + 1;
            // 第二个指针是最后一个数据，从右向左遍历
            int end = nums.length - 1;
            while (start < end) {
                // 如果总和大于0，右边的指针左移
                if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                    //如果总和小于0，左边的指针右移
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    // 如果当前start < end, 第一个指针当前值与 第一个指针下一个值相等的时候，一直做++start的操作
                    while (start < end && nums[start] == nums[++start]) ;
                    // 如果当前start < end, 第二个指针当前值与 第二个指针前一个值相等的时候，一直做--end的操作
                    while (start < end && nums[end] == nums[--end]) ;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0};
        System.err.println(threeSum(nums));
        System.err.println(threeSum2(nums));
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        if (nums[0] > 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    while (start < end && nums[start] == nums[--end]) ;
                    while (start < end && nums[++start] == nums[end]) ;
                }
            }
        }
        return result;
    }


}
