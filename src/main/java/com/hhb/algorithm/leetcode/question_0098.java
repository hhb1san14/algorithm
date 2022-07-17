package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhb
 * @date 2022/7/17
 * @description98. 验证二叉搜索树 https://leetcode.cn/problems/validate-binary-search-tree/
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
public class question_0098 {
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        if (list.size() <= 1) {
            return flag;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) < list.get(i)) {
                continue;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public boolean isValidBST2(TreeNode root) {
        return inValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean inValidBST2(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        // 如果当前节点小于最小值或者大于最大值，都返回false
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        // 传到下一层，传左子节点时，当前层的val是下一层的最大值，
        // 传到下一层，传右子节点时，当前层的val是下一层的最小值，
        return inValidBST2(root.left, minValue, root.val) && inValidBST2(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        node.left = left;
        node.right = right;
        question_0098 obj = new question_0098();
        System.err.println(obj.isValidBST2(node));
    }
}
