package com.hhb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @description:111. 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 * @author: huanghongbo
 * @date: 2021-08-11 20:15
 **/
public class question_0111 {

    private static int i = 0;

    // 深度优先
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    //利用队列，广度优先
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int min = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node.left == null && node.right == null) {
                    return ++min;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            min++;

        }
        return min;
    }


    public static int[] sort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int left, int right) {
        int low = left;
        int high = right;
        int key = arr[low];
        while (low < high) {

            while (low < high && arr[high] >= key) {
                high--;
            }
            if (low < high && arr[high] <= key) {
                int temp = arr[high];
                arr[high] = key;
                arr[low] = temp;
            }
            while (low < high && arr[low] <= key) {
                low++;
            }
            if (low < high && arr[low] >= key) {
                int temp = arr[low];
                arr[low] = key;
                arr[high] = temp;
            }
        }
        if (low > left) {
            sort(arr, left, low - 1);
        }
        if (high < right) {
            sort(arr, high + 1, right);
        }
    }


    public static ListNode reverseList(ListNode head) {
        //当前节点为空或整个链表只有当前节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode pre = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static synchronized void add() {
        i++;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10000, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 10000; i++) {
            question_0111 question_0111 = new question_0111();
            executorService.execute(() -> question_0111.add());
        }
        System.err.println(i);

        executorService.shutdown();
    }

}
