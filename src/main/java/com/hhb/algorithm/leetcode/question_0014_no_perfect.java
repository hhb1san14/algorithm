package com.hhb.algorithm.leetcode;

/**
 * @description:14. 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-26 11:14
 **/
public class question_0014_no_perfect {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String result = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("")) {
                return "";
            }
            if (result.equals(strs[i])) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < Math.min(result.length(), strs[i].length()); j++) {
                if (strs[i].charAt(j) != result.charAt(j)) {
                    result = sb.toString();
                    if (result.equals("")) {
                        return "";
                    }
                    break;
                } else {
                    sb.append(result.charAt(j));
                    if (j == Math.min(result.length(), strs[i].length()) - 1) {
                        result = sb.toString();
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
        System.err.println(s);

    }

}
