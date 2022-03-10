package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:22. 括号生成  https://leetcode-cn.com/problems/generate-parentheses/
 * <p>
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-08-11 19:50
 **/
public class question_0022 {


    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        gen(0, 0, n, list, "");
        System.err.println(list);
        return list;
    }

    public static void gen(int left, int right, int n, List<String> list, String result) {
        if (left == n && right == n) {
            list.add(result);
            return;
        }
        if (left < n) {
            gen(left + 1, right, n, list, result + "(");
        }
        if (right < n && right < left) {
            gen(left, right + 1, n, list, result + ")");
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }


}
