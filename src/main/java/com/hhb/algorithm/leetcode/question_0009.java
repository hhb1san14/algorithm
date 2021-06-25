package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:9. 回文数 https://leetcode-cn.com/problems/palindrome-number/
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 *  
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-23 16:09
 **/
public class question_0009 {

    // 该办法存在使用int最大值，然后超出范围问题 2147483647
    public static boolean isPalindrome(int x) {
        int result = x;
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }

        int size = list.size();
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp += list.get(i) * Math.pow(10, size - 1);
            size--;
        }
        return temp == result;
    }


    public static boolean isPalindrome2(int x) {

        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


    public static boolean isPalindrome3(int x) {
        //x 小于0的时候，不是回文
        // 当x 末尾 为 0的时候，如果满足回文，要求首位也是0，那只有0 满足该情况
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int temp = 0;
        //
        while (x > temp) {
            temp = x % 10 + temp * 10;
            x /= 10;
        }
        //如果是偶数，temp 应该直接等于 x
        //如果是奇数，temp去除最后一位，即奇数的中间位， 也应该是相等的
        return temp == x || x == temp / 10;
    }

    public static void main(String[] args) {
        System.err.println(isPalindrome3(10));
    }

}
