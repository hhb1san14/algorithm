package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @author: huanghongbo
 * @Date: 2020-05-20 16:56
 * @Description: 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class question_0239 {

    /**
     * 暴力破解，但是超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        int index = 0;
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (list.size() < k) {
                list.add(nums[i]);
            }
            if (list.size() == k) {
                arr[index] = sort(list);
                list.remove(0);
                index++;
            }
        }
        return arr;
    }

    public static int sort(List<Integer> list) {
        List<Integer> temp = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));
        }
        Collections.sort(temp);
        return temp.get(temp.size() - 1);
    }


    /**
     * 使用优先队列,超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.reverseOrder());
        int[] arr = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            if (priorityQueue.size() < k) {
                priorityQueue.add(nums[i]);
            }
            if (priorityQueue.size() == k) {
                arr[index] = priorityQueue.peek();
                priorityQueue.remove(nums[i - k + 1]);
                index++;
            }
        }
        return arr;
    }


    /**
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums.length < k) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 如果队列是非空，而且num[队列的最后面的值] < num[i],直接让最后的索引弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            // 如果队列的头部，已经出了窗口，弹出
            if (queue.peek() <= i - k) {
                queue.poll();
            }

            // 索引长度达到了窗口的值
            if (i + 1 >= k) {
                result[i - k + 1] = nums[queue.peek()];
            }


        }
        return result;
    }


    /**
     * 暴力破解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow4(int[] nums, int k) {
        if (nums == null) {
            return new int[0];
        }
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            arr[i] = max;

        }
        return arr;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] arr = {1, -1};
        int[] ints = maxSlidingWindow3(arr, 1);
        System.err.println("====");
    }

}
