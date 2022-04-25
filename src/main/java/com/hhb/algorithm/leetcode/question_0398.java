package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @author hhb
 * @date 2022/4/25
 * @description398. 随机数索引 https://leetcode-cn.com/problems/random-pick-index/
 * 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution(int[] nums) 用数组 nums 初始化对象。
 * int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i 。如果存在多个有效的索引，则每个索引的返回概率应当相等。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Solution", "pick", "pick", "pick"]
 * [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * 输出
 * [null, 4, 0, 2]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3, 3, 3]);
 * solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
 * solution.pick(1); // 返回 0 。因为只有 nums[0] 等于 1 。
 * solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * target 是 nums 中的一个整数
 * 最多调用 pick 函数 104 次
 *  
 * <p>
 */
public class question_0398 {

    //    //方法一：
//    private Map<Integer, List<Integer>> map = new HashMap<>();
//
//    public question_0398(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> list = map.get(nums[i]);
//            if (list == null) {
//                list = new ArrayList<>();
//            }
//            list.add(i);
//            map.put(nums[i], list);
//        }
//    }
//
//    public int pick(int target) {
//        List<Integer> list = map.get(target);
//        return list.get(new Random().nextInt(list.size()));
//    }
//方法二：

    private Random random;

    private int[] nums;

    public question_0398(int[] nums) {
        random = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        question_0398 question_0398 = new question_0398(new int[]{1, 2, 3, 3, 3,});
        int pick = question_0398.pick(3);
        System.err.println(pick);
    }
}
