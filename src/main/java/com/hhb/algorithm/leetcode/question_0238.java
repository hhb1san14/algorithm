package com.hhb.algorithm.leetcode;

/**
 * @description:238. 除自身以外数组的乘积 https://leetcode-cn.com/problems/product-of-array-except-self/
 * <p>
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-09-06 15:50
 **/
public class question_0238 {
    //O(n^2) 暴力破解，时间超时
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int r = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    r *= nums[j];
                }
            }
            result[i] = r;
        }
        return result;
    }


    /**
     * 原数组：       [1       2       3       4]
     * 左部分的乘积：   1       1      1*2    1*2*3
     * 右部分的乘积： 2*3*4    3*4      4      1
     * 结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
     *
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf2(int[] nums) {

        int[] leftArr = new int[nums.length];
        int[] rightArr = new int[nums.length];
        leftArr[0] = 1;
        rightArr[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftArr[i] = nums[i - 1] * leftArr[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rightArr[i] = nums[i + 1] * rightArr[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = leftArr[i] * rightArr[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        productExceptSelf2(arr);
    }
}
