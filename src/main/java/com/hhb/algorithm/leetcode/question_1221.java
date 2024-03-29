package com.hhb.algorithm.leetcode;

import java.util.Stack;

/**
 * @description:1221. 分割平衡字符串 https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 2：
 * <p>
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 3：
 * <p>
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 * 示例 4：
 * <p>
 * 输入：s = "RLRRRLLRLL"
 * 输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * s 是一个 平衡 字符串
 * @author: huanghongbo
 * @date: 2021-09-07 09:54
 **/
public class question_1221 {

    //时间复杂度O(n),利用栈，自己的写法
    public int balancedStringSplit(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    //时间复杂度O(n)，空间复杂度O(1)
    public int balancedStringSplit2(String s) {
        int temp = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                temp--;
            } else {
                temp++;
            }
            if (temp == 0) {
                result++;
            }
        }
        return result;
    }


}
