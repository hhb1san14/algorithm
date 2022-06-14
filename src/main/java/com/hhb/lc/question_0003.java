package com.hhb.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hhb
 * @date 2022/6/8
 * @description
 */
public class question_0003 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = Integer.MIN_VALUE;
        int left = 0;
        //key：字符串的每一个字符的值 value: 该字符的索引
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // s="abba"
                //假设当前left = 0，i = 2，此时无重复子串为ab，最大长度为2,
                //当i = 2的时候，map中原来含有字符b,所以left 应该等于map中字符b的索引+1.也就是left = 2
                // 当 i= 3的时候，map：{a:0,b:2},如果完全按照上面的逻辑，left = 0+ 1,（a的索引+1）
                // 但是由于之前left都已经为2了，所以此时left应该是max(left,0+1(a的索引+1))
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //将该字符的最新的索引放到map中
            map.put(s.charAt(i), i);
            //无重复字符串的长度是最右的的索引+1（右指针） - left(左指针)
            max = Math.max(max, i + 1 - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.err.println(lengthOfLongestSubstring("abba"));
    }


}
