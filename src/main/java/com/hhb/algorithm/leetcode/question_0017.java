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
        if(digits.length() > 0){
            letterCombinations(digits,list,new StringBuilder(),0);
        }
        return list;
    }

    private static void letterCombinations(String digits, List<String> list, StringBuilder sb,int index) {
        if(sb.length() == digits.length()){
            list.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            letterCombinations(digits,list,sb,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.err.println(strings);
    }
}
