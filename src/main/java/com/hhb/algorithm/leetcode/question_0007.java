package com.hhb.algorithm.leetcode;

/**
 * @description:7. 整数反转 https://leetcode-cn.com/problems/reverse-integer/
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-05-25 10:43
 **/
public class question_0007 {

    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int i = 1;
        if (x < 0) {
            i = -1;
        }
        Long abs = (long) (x) * i;
        String xStr = String.valueOf(abs);
        int length = xStr.length() - 1;
        long result = 0;
        while (length >= 0) {
            result += Long.parseLong(String.valueOf(xStr.charAt(length))) * Math.pow(10, length);
            length--;
        }
        result = result * i;
        if (result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE) {
            return (int) result;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.err.println(reverse2(-156384741));
    }

    public static int reverse2(int x) {
        if (x == 0) {
            return x;
        }
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int dist = x % 10;
            x /= 10;
            result = result * 10 + dist;
        }
        return result;
    }


}
