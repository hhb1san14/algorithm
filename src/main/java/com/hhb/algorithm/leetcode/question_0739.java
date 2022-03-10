package com.hhb.algorithm.leetcode;

import java.util.Stack;

/**
 * @description:739. 每日温度 https://leetcode-cn.com/problems/daily-temperatures/
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * @author: huanghongbo
 * @date: 2021-08-03 08:53
 **/
public class question_0739 {


    /**
     * 时间复杂度度O(n^2),属于暴力破解法
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{0};
        }
        int[] result = new int[temperatures.length];
        int[] temp = new int[temperatures.length];
        temp[temperatures.length - 1] = temperatures[result.length - 1];
        result[temperatures.length - 1] = 0;
        int j = -1;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            temp[i] = temperatures[i];
            j = i + 1;
            if (temperatures[i] < temp[j]) {
                result[i] = 1;
                continue;
            }
            while (temperatures[i] >= temp[j] && j < temperatures.length - 1) {
                j++;
            }
            if (j == temperatures.length - 1 && temperatures[i] >= temp[j]) {
                result[i] = 0;
            } else {
                result[i] = j - i;
            }
        }
        return result;
    }


    /**
     * 使用Stack，时间复杂度O(n)
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures2(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer index = stack.pop();
                if (temperatures[i] > temperatures[index]) {
                    result[index] = i - index;
                }
            }
            stack.push(i);
        }
        return result;
    }


    public static void main(String[] args) {
//        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
//        dailyTemperatures(new int[]{30,40,50,60});
        dailyTemperatures2(new int[]{30, 40, 60});


    }

}
