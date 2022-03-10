package com.hhb.algorithm.leetcode;

/**
 * @description:162. 寻找峰值 https://leetcode-cn.com/problems/find-peak-element/
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-09-15 10:02
 **/
public class question_0162 {

    // 暴力破解，时间复杂度O(n)
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] - nums[1] > 0 ? 0 : 1;
        }

        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1] && flag) {
                continue;
            } else {
                flag = false;
            }
        }
        if (flag) {
            return 0;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }


    //要求使用时间复杂度O(logn),使用二分法
    public static int findPeakElement2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            //如果中间节点 大于 中间节点 + 1 位置的数据，说明左侧有数据比右侧大，那么峰值在左侧一定存在
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {// 否则说明峰值在右侧一定存在
                left = middle + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        findPeakElement2(new int[]{1, 2});
    }

}
