package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @description:347. 前 K 个高频元素 https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *  
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-28 10:06
 **/
public class question_0347 {

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer key : nums) {

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue(k, (Comparator<Integer>) (o1, o2) -> map.get(o2) - map.get(o1));
        for (Integer key : map.keySet()) {
            queue.offer(key);
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                arr[i] = queue.poll();
            }
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int[] result = topKFrequent(arr, 2);
        for (int i : result) {
            System.err.print(i + "\t");
        }


    }


}
