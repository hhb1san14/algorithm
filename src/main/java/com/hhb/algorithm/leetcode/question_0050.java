package com.hhb.algorithm.leetcode;

/**
 * @description:50. Pow(x, n) https://leetcode-cn.com/problems/powx-n/
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *  
 * @author: huanghongbo
 * @date: 2021-08-30 14:45
 **/
public class question_0050 {


    public static double myPow(double x, int n) {
        long N = n;
        if (N == 0) {
            return 1;
        }
        if (N < 0) {
            return 1 / myPow(x, -N);
        }
        return myPow(x, N);
    }

    public static double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        return x * myPow(x, n - 1);
    }

    public static void main(String[] args) {
        System.err.println(myPow(1.00000, -2147483648));
    }
}
