package com.hhb.algorithm.leetcode;

/**
 * @description:278. 第一个错误的版本 https://leetcode-cn.com/problems/first-bad-version/
 * <p>
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：false  false  false true  true
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 * <p>
 * 输入：n = 1, bad = 1
 * 输出：1
 * <p>
 * <p>
 * false  true  true
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-07-13 15:37
 **/
public class question_0278 {


    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int temp = start + (end - start) / 2;
            if (isBadVersion(temp)) {
                end = temp - 1;
            } else {
                start = temp + 1;
            }
        }
        return start;
    }


    public static boolean isBadVersion(int n) {
        if (n >= 1) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.err.println(firstBadVersion(5));
    }
}
