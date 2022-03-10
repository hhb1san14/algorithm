package com.hhb.algorithm.leetcode;

/**
 * @description:461. 汉明距离  https://leetcode-cn.com/problems/hamming-distance/
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= x, y <= 231 - 1
 * @author: huanghongbo
 * @date: 2021-09-02 11:11
 **/
public class question_0461_no_perfect {

    /**
     * 暴力破解
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int result = 0;
        String xBin = Integer.toBinaryString(x);
        String yBin = Integer.toBinaryString(y);
        int index = Math.abs(xBin.length() - yBin.length());
        StringBuilder sb = new StringBuilder();
        while (index > 0) {
            sb.append("0");
            index--;
        }
        if (xBin.length() <= yBin.length()) {
            xBin = sb.toString() + xBin;
        } else {
            yBin = sb.toString() + yBin;
        }
        int length = xBin.length();
        while (length > 0) {
            if (xBin.charAt(length - 1) != yBin.charAt(length - 1)) {
                result++;
            }
            length--;
        }
        return result;

    }


    public static void main(String[] args) {
        System.err.println(hammingDistance(1, 4));
    }

}
