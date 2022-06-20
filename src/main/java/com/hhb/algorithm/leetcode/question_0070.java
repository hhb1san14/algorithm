package com.hhb.algorithm.leetcode;

/**
 * @description:70. 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @author: huanghongbo
 * @date: 2021-09-22 11:39
 **/
public class question_0070 {

    /**
     * 暴力破解法，最后一步台阶，可能
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    //超出时间限制，结果正确 // N = 45  RESULT = 1836311903
    public static int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }

    // N = 45  RESULT = 1836311903
    public static int climbStairs4(int n) {
        if (n <= 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * n = 1 ，result = 1
     * n = 2 ，result = 2
     * n = 3 , result = f(1) + f(2) = f(n - 1) + f(n -2);
     *
     * @param n
     * @return
     */
    public static int climbStairs5(int n) {
        if (n <= 2) {
            return n;
        }
        int result = 0;
        int left = 1;
        int right = 2;
        for (int i = 3; i <= n; i++) {
            result = left + right;
            left = right;
            right = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.err.println(climbStairs5(45));

    }
}
