package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: question_0515
 * @Date: 2022/8/2 20:15
 * @Author: huanghongbo
 * @Description:515. 在每个树行中找最大值 https://leetcode.cn/problems/find-largest-value-in-each-tree-row/#/description
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * 示例1：
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * <p>
 * 提示：
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 */
public class question_0515 {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                maxValue = Math.max(treeNode.val, maxValue);
                TreeNode left = treeNode.left;
                if (left != null) {
                    queue.offer(left);
                }
                TreeNode right = treeNode.right;
                if (right != null) {
                    queue.offer(right);
                }
                size--;
            }
            list.add(maxValue);
        }
        return list;
    }

}
