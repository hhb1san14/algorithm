package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-09 14:18
 * @Description:x 的平方根 https://leetcode-cn.com/problems/sqrtx/
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class question_0069 {

    public static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        long max = Long.valueOf(x);
        long min = x;
        while (true) {
            Long result = min * min;
            if (result > x) {
                max = min;
                min = getValue(min);
            } else {
                if ((min + 1) * (min + 1) > x) {
                    return (int) (min);
                } else {
                    min = getValue(max + min);
                }
            }
        }
    }

    public static long getValue(long x) {
        return x / 2;
    }

    public static void main(String[] args) {
        System.err.println(mySqrt2(2147395600));
    }

    public static int mySqrt2(int x) {
        long max = x;
        long min = 0;
        while (true) {
            min = getValue(max + min);
            long result = min * min;
            if (result == x) {
                return (int) min;
            } else if (result > x) {
                max = min;
                min = getValue(min);
            } else {
                if ((min + 1) * (min + 1) > x) {
                    return (int) min;
                }
            }
        }


    }


}
