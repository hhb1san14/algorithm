package com.hhb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-22 08:33
 **/
public class question_0104 {


    // 深度优先遍历
    public static int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public static int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        return Math.max(maxDepth(root.left, depth), maxDepth(root.right, depth));
    }


    // 广度优先遍历,利用队列先进先出的原则，一层一层遍历。
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                size--;
            }
            result++;
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(4);
        TreeNode left4 = new TreeNode(5);
        TreeNode right1 = new TreeNode(6);
        TreeNode right2 = new TreeNode(7);
        TreeNode right3 = new TreeNode(8);
        TreeNode right4 = new TreeNode(9);
        TreeNode right5 = new TreeNode(10);
        TreeNode left5 = new TreeNode(11);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = left3;
        left2.left = left5;
        left3.right = left4;
        right1.left = right2;
        right1.right = right3;
        right2.right = right4;
        right3.left = right5;
        System.err.println(maxDepth(root));
    }

    public static int maxDepth1(TreeNode root) {
        return depth(root);
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.right), depth(root.left)) + 1;
    }


}
