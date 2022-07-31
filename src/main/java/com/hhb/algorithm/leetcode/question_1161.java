package com.hhb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: question_1161
 * @Date: 2022/7/31 20:51
 * @Author: huanghongbo
 * @Description: 1161. 最大层内元素和 https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * 示例 1：
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * 提示：
 * 树中的节点数在 [1, 104]范围内
 * -105 <= Node.val <= 105
 */
public class question_1161 {

    public static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int result = 1;
        int temp = Integer.MIN_VALUE;
        int index = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            index++;
            int sum = 0;
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                sum += treeNode.val;
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
            if (temp < sum) {
                temp = sum;
                result = index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode treeNode8 = new TreeNode(-8);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode77 = new TreeNode(7,treeNode7,treeNode8);
//        TreeNode treeNode0 = new TreeNode(0);
//        TreeNode root = new TreeNode(1,treeNode77,treeNode0);
        TreeNode root = new TreeNode(989);
        TreeNode treeNode2 = new TreeNode(10250);
        TreeNode treeNode3 = new TreeNode(98693);
        TreeNode treeNode4 = new TreeNode(-89388);
        TreeNode treeNode5 = new TreeNode(-32127);
        root.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode4.right = treeNode5;
        System.err.println(maxLevelSum(root));
    }
}
