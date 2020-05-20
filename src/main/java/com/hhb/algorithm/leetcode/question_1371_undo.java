package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-20 09:13
 * @Description: 每个元音包含偶数次的最长子字符串 https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * <p>
 * <p>
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * 示例 2：
 * <p>
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * 示例 3：
 * <p>
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 */
public class question_1371_undo {


    /**
     * 结果正确，超时
     * @param s
     * @return
     */
    public static int findTheLongestSubstring(String s) {
        int max = 0;
        int index = 0;
        int result = 0;
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        while (index < s.length()) {
            for (int j = index; j < s.length(); j++) {
                if (s.charAt(j) == 'a') {
                    a++;
                } else if (s.charAt(j) == 'e') {
                    e++;
                } else if (s.charAt(j) == 'i') {
                    i++;
                } else if (s.charAt(j) == 'o') {
                    o++;
                } else if (s.charAt(j) == 'u') {
                    u++;
                }
                result++;
                if (a % 2 == 0 && e % 2 == 0 && i % 2 == 0 && o % 2 == 0 && u % 2 == 0) {
                    max = Math.max(max, result);
                }
            }
            index++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.err.println(findTheLongestSubstring("eleetminicoworoep"));
    }


}
