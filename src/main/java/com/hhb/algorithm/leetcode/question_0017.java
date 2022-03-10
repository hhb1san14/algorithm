package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:17. 电话号码的字母组合  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * @author: huanghongbo
 * @date: 2021-09-08 13:49
 **/
public class question_0017 {

    static Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };


    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() < 1) {
            return list;
        }
        int depth = 0;

        letterCombinations(list, digits, depth, new StringBuilder());
        return list;


    }

    //                     2
    //     a               b               c
    //      3               3               3
    //d    e   f       d   e   f       d   e    f
    // ad   ae  af      bd  be  bf      cd   ce  cf
    private static void letterCombinations(List<String> list, String digits, int depth, StringBuilder sb) {
        //利用depth记录遍历地索引，当改大小和输入的长度一致时候，索引遍历完了一条路，将数据放到list
        if (depth == digits.length()) {
            list.add(sb.toString());
        } else {
            //获取当前数字，有哪些字母
            String str = map.get(digits.charAt(depth));
            for (int i = 0; i < str.length(); i++) {
                //利用sb记录每次遍历的值
                sb.append(str.charAt(i));
                //回溯-递归
                letterCombinations(list, digits, depth + 1, sb);
                // 此时sb：ad,需要遍历到e ，所以需要将d删除
                sb.deleteCharAt(depth);
            }
        }

    }


    public static void main(String[] args) {
        letterCombinations("23");
    }
}
