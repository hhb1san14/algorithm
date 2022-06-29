package com.hhb.algorithm.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: huanghongbo
 * @Date: 2020-04-14 15:55
 * @Description: 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 */
public class question_0020 {


    public static boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack stackLeft = new Stack();
        for (int i = 0; i < length; i++) {
            if ("{".equals(String.valueOf(s.charAt(i)))) {
                stackLeft.add("}");
            } else if ("[".equals(String.valueOf(s.charAt(i)))) {
                stackLeft.add("]");
            } else if ("(".equals(String.valueOf(s.charAt(i)))) {
                stackLeft.add(")");
            } else {

                if (!stackLeft.empty() && !stackLeft.pop().equals(String.valueOf(s.charAt(i)))) {
                    return false;
                }
            }
        }
        return stackLeft.empty();
    }


    public static boolean isValid2(String s) {

        Stack<Character> stackLeft = new Stack();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stackLeft.push(s.charAt(i));
            } else {
                if (stackLeft.empty() || !map.get(s.charAt(i)).equals(stackLeft.pop())) {
                    return false;
                }
            }
        }
        return stackLeft.empty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.err.println(isValid3(s));
    }


    public static boolean isValid3(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
                } else if (!stack.isEmpty() && stack.pop() != c) {
                    return false;
                }
            }
            return stack.isEmpty();
    }


}
