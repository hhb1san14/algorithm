package com.hhb.algorithm.leetcode;

/**
 * @author hhb
 * @date 2022/7/19
 * @description50. Pow(x, n) https://leetcode.cn/problems/powx-n/
 * <p>
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *  
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question_0050 {

    /**
     * 自己的写法，超时
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow3(double x, int n) {
        if (n == 0) {
            return 1;
        }
        Double result = 1.0;
        for (int i = 0; i < Math.abs(n); i++) {
            result *= x;
        }
        return n > 0 ? result : 1 / result;
    }

    /**
     * 递归
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        double result = pow(x, Math.abs(n));
        return n >= 0 ? result : 1 / result;

    }

    /**
     * x^64 = x -> x^2 -> x^4 -> x^8 -> x^16 -> x^32 -> x^64
     * 计算x^n 时候，先计算 x ^ (n/2),如果n % 2 != 0,最后在乘一个x；
     *
     * @param x
     * @param n
     * @return 递归前：n =》5
     * 递归前：n =》2
     * 递归前：n =》1
     * 递归后: n=>1,y=>1.0
     * 递归后: n=>2,y=>2.0
     * 递归后: n=>5,y=>4.0
     */
    private static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        System.err.println("递归前：n =》" + n);
        double y = pow(x, n / 2);
        System.err.println("递归后: n=>" + n + ",y=>" + y);
        return n % 2 == 0 ? y * y : y * y * x;
    }


    /**
     * 改造迭代
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        Double result = 1.0;
        //使用折半计算，每次把n缩小一半，这样n最终会缩小到0，任何的
        for (int i = n; i != 0; i = i / 2) {
            //如果i是奇数，把上次幂
            if (i % 2 != 0) {
                result *= x;
            }
            // 如果是偶数，
            x *= x;

        }
        return n > 0 ? result : 1 / result;
    }


    public static void main(String[] args) {
        System.err.println(myPow2(2, 10));
    }
}
