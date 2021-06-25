package com.hhb.algorithm.offer;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @description: 剑指 Offer 15. 二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *  
 * <p>
 * 提示：
 * <p>
 * 输入必须是长度为 32 的 二进制串 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-23 08:59
 **/
public class offer_015 {

    public static void main(String[] args) {
        TreeSet<Object> objects = new TreeSet<>();
        objects.add(123);
//        System.err.println(hammingWeight2(5));

    }



    // you need to treat n as an unsigned value
    public static int hammingWeight2(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;

        }
        return result;
    }


    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {


        TreeMap<String, String> stringStringTreeMap = new TreeMap<String, String>();
        stringStringTreeMap.put("1","");
        int index = n;
        int result = 0;
        n = Math.abs(n);
        while (n != 0) {
            System.err.println(n % 2);
            if (n % 2 == 1) {
                result++;
            }
            n /= 2;
        }
        if (index < 0) {
            return 32 - result;
        }
        return result;
    }
}
