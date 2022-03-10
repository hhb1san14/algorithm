package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @description:100. 相同的树 https://leetcode-cn.com/problems/same-tree/
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 * <p>
 * <p>
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 * @author: huanghongbo
 * @date: 2021-09-14 13:33
 **/
public class question_0100 {
    static Stack<Integer> pStack = new Stack<>();
    static Stack<Integer> qStack = new Stack<>();

    /**
     * 暴力破解
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        getPStack(p);
        getQStack(q);
        while (!pStack.isEmpty() || !qStack.isEmpty()) {
            if (pStack.isEmpty() && !qStack.isEmpty()) {
                return false;
            }
            if (!pStack.isEmpty() && qStack.isEmpty()) {
                return false;
            }
            if (pStack.pop() == qStack.pop()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void getPStack(TreeNode root) {
        if (root == null) {
            return;
        }
        getPStack(root.left);
        pStack.add(root.val);
        getPStack(root.right);
    }

    public static void getQStack(TreeNode root) {
        if (root == null) {
            return;
        }
        getQStack(root.left);
        qStack.add(root.val);
        getQStack(root.right);
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode();
//        TreeNode p2 = new TreeNode(2);
//        TreeNode p3 = new TreeNode(3);
//        p1.left = p2;
//        p1.right = p3;
        TreeNode q1 = new TreeNode(1);
//        TreeNode q2 = new TreeNode(2);
//        TreeNode q3 = new TreeNode(2);
//        q1.left = q2;
//        q1.right = q3;
        isSameTree3(p1, q1);

    }


    /**
     * 看了答案后的深度优先
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (q == null || p == null) {
            return false;
        } else if (q.val != p.val) {
            return false;
        } else {
            return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
        }
    }


    /**
     * 广度优先
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree3(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while (!qQueue.isEmpty() || !pQueue.isEmpty()) {
            if (qQueue.isEmpty() || pQueue.isEmpty()) {
                return false;
            }
            TreeNode qNode = qQueue.poll();
            TreeNode pNode = pQueue.poll();
            if ((qNode != null && pNode == null) || (qNode == null && pNode != null)) {
                return false;
            }
            if (qNode.val != pNode.val) {
                return false;
            }
            if ((pNode.left == null && qNode.left != null) || (pNode.left != null && qNode.left == null)) {
                return false;
            }
            if ((pNode.right != null && qNode.right == null) || (pNode.right == null && qNode.right != null)) {
                return false;
            }
            if (pNode.left != null) {
                pQueue.offer(pNode.left);
            }
            if (pNode.right != null) {
                pQueue.offer(pNode.right);
            }
            if (qNode.left != null) {
                qQueue.offer(qNode.left);
            }
            if (qNode.right != null) {
                qQueue.offer(qNode.right);
            }
        }
        return true;
    }


}
