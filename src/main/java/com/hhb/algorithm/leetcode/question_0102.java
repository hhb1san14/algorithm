package com.hhb.algorithm.leetcode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description: 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-06-22 09:27
 **/
public class question_0102 {


    // 广度优先遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                size--;
            }
            result.add(list);
        }
        return result;
    }


    public static void main(String[] args) {
        //                  1
        //       2                      6
        //  3       4             7            8
        //11            5             9     10


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
        System.err.println(levelOrder(root));
        System.err.println(levelOrder2(root));
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                l.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                size--;
            }
            list.add(l);
        }
        return list;
    }


}
