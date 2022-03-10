package com.hhb.algorithm.leetcode;

/**
 * @description: 371. 两整数之和 https://leetcode-cn.com/problems/sum-of-two-integers/
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：a = 2, b = 3
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * -1000 <= a, b <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-09-26 15:09
 **/
public class question_0371_not_understand {
    public static int getSum(int a, int b) {
        String a1 = Integer.toBinaryString(a);
        String b1 = Integer.toBinaryString(b);


        return 0;
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
            System.err.println("a = " + a + ",b = " + b);

        }
        System.err.println(a);
    }

}
