package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:187. 重复的DNA序列 https://leetcode-cn.com/problems/repeated-dna-sequences/
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 * @author: huanghongbo
 * @date: 2021-10-08 15:26
 **/
public class question_0187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 10;
        while (right <= s.length()) {
            String key = s.substring(left, right++);
            left++;
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                if (value == 1) {
                    result.add(key);
                }
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        return result;
    }


}
