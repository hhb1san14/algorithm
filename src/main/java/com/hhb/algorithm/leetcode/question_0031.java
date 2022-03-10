package com.hhb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @description: 31. 下一个排列 https://leetcode-cn.com/problems/next-permutation/
 * <p>
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,2,1,1]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-07-27 10:59
 **/
public class question_0031{

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        //从后向前找，找到第一个左边数字 小于 右边 数字为的索引
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //入股该索引位置 大于0，说明存在这样的数，否则说明当前的数据是该数组的最大排列方式
        if (i >= 0) {
            //再次重后向前遍历
            for (int j = nums.length - 1; j >= 0; j--) {
                //判断第一个比 索引 i 大的数字,然后进行交换
                if (nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    // 交换后，对交换后索引 + 1 到 数组末尾 重新从小到大进行排序
                    Arrays.sort(nums, i + 1, nums.length);
                    break;
                }
            }
            //从小到大重新排序
        } else {
            Arrays.sort(nums);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        nextPermutation(arr);
    }


}
