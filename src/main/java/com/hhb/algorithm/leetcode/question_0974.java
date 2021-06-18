package com.hhb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huanghongbo
 * @Date: 2020-05-27 12:49
 * @Description: 和可被 K 整除的子数组 https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * <p>
 * <p>
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * <p>
 */
public class question_0974 {


    public static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 0, -2, -3, 1};
        int i = subarraysDivByK(arr, 5);
        System.err.println(i);
    }
}
