package com.hhb.algorithm.leetcode;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:22. 括号生成  https://leetcode-cn.com/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * 1 <= n <= 8
 * @author: huanghongbo
 * @date: 2021-08-11 19:50
 **/
public class question_0022 {


    /**
     * 假设不考虑括号的合法性，就是生成，输入n的时候，保证输出2*n长度的字符串
     * 字符串中包含 （ 和 ）
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesisTest(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesisTest(0, 2 * n, "");
        return list;
    }

    /**
     * @param level   表示当前层级，
     * @param max     表示最大层级
     * @param currStr 当前层级时候的字符串
     */
    private static void generateParenthesisTest(int level, int max, String currStr) {
        // 递归第一步，定义跳出递归的条件
        if (level == max) {
            System.err.println(currStr);
            return;
        }
        // 第二步： 处理当前层的逻辑，当前层的逻辑只有两种可能，要不然加左括号，要不然加右括号
        String s1 = currStr + "(";
        String s2 = currStr + ")";
        // 第三步：进入下一层
        generateParenthesisTest(level + 1, max, s1);
        generateParenthesisTest(level + 1, max, s2);
        // 第四步:从下一层返回到当前层，清理当前层
    }


    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(0, 0, n, list, "");
        return list;
    }

    /**
     * 生成括号
     *
     * @param left  左括号的数量
     * @param right 右括号的数量
     * @param n     括号的最大数量
     * @param list  保存合格括号的集合
     * @param s     当前层括号的字符串
     */
    private static void generateParenthesis(int left, int right, int n, List<String> list, String s) {
        //定义
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        //如果左括号的数量小于括号的数量，说明可以拼接左括号
        if (left < n) {
            generateParenthesis(left + 1, right, n, list, s + "(");
        }
        //如果右括号的数量小于括号的数量，且右括号的数量要小于左括号，否则不是合法的括号，才可以添加右括号
        if (right < n && right < left) {
            generateParenthesis(left, right + 1, n, list, s + ")");
        }
    }

    public static void main(String[] args) {
//        System.err.println(generateParenthesisTest(3));

//        System.err.println(generateParenthesis(3));
        System.err.println(generateParenthesis2(3));
    }

    public static List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis2(list, n, 0, 0, "");
        return list;

    }

    private static void generateParenthesis2(List<String> list, int n, int left, int right, String str) {
        if (n == left && n == right) {
            list.add(str);
            return;
        }
        if (left < n) {
            generateParenthesis2(list, n, left + 1, right, str + "(");
        }
        if (right < left) {
            generateParenthesis2(list, n, left, right + 1, str + ")");
        }
    }


}
