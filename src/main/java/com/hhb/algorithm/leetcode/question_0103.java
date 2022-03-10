package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @description: 103. 二叉树的锯齿形层序遍历  https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * @author: huanghongbo
 * @date: 2021-09-14 15:19
 **/
public class question_0103 {

    /**
     * 广度优先遍历，利用栈和队列
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                //放到栈中，利用栈的先进后出的特点，当level % 2 == 0，数据从左至右放， stack : 头 - 尾： 3  2
                if (level % 2 == 0) {
                    if (treeNode.left != null) {
                        stack.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stack.add(treeNode.right);
                    }
                } else { // 当level % 2 != 0，数据从右至右左， stack : 头 - 尾： 4  5  6  7
                    if (treeNode.right != null) {
                        stack.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stack.add(treeNode.left);
                    }
                }
                size--;
            }
            while (!stack.isEmpty()) { // 将栈中的数据弹出，依次放到队列中
                queue.offer(stack.pop());
            }
            level++; // 没遍历一层，层级+1
            list.add(temp);
        }
        return list;
    }


    /**
     * 1
     * 2        3
     * 4    5   6     7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        System.err.println(zigzagLevelOrder(root));
    }
}
