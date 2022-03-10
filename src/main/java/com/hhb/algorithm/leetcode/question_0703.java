package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @description:703. 数据流中的第 K 大元素 https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * <p>
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * <p>
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *  
 * <p>
 * 提示：
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-24 14:05
 **/
public class question_0703 {

    private int k;

    private List<Integer> list;

    public question_0703(int k, int[] nums) {
        list = new ArrayList<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }

    }

    public int add(int val) {
        if (list.size() < k) {
            list.add(val);
        } else {
            Collections.sort(list);
            if (list.get(0) < val) {
                list.set(0, val);
            }
        }

        Collections.sort(list);
        return list.get(0);

    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        question_0703 question_0703 = new question_0703(3, nums);
        System.err.println(question_0703.add(3));
        System.err.println(question_0703.add(5));
        System.err.println(question_0703.add(10));
        System.err.println(question_0703.add(9));
        System.err.println(question_0703.add(4));
//        int[] nums = {};
//        question_0703 question_0703 = new question_0703(1, nums);
//        System.err.println(question_0703.add(-3));
//        System.err.println(question_0703.add(-2));
//        System.err.println(question_0703.add(-4));
//        System.err.println(question_0703.add(0));
//        System.err.println(question_0703.add(4));

//        ["KthLargest", "add", "add", "add", "add", "add"]
//[[1,[]],[-3],[-2],[-4],[0],[4]]
    }


}
