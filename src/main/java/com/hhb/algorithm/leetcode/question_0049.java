package com.hhb.algorithm.leetcode;


import java.util.*;

/**
 * @author hhb
 * @date 2022/7/7
 * @description49. 字母异位词分组 https://leetcode.cn/problems/group-anagrams/
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class question_0049 {

    /**
     * 暴力破解，利用map，将数组中的每个字符串排序后，作为key，将相同值时的index作为value
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length < 1) {
            return res;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<Integer> list = map.get(s);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(s, list);
        }

        Iterator<Map.Entry<String, List<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            List<Integer> indexList = iterator.next().getValue();
            List<String> list = new ArrayList<>();
            for (int index : indexList) {
                list.add(strs[index]);
            }
            res.add(list);
        }
        return res;
    }


    /**
     * 标准答案
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length < 1) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

}
