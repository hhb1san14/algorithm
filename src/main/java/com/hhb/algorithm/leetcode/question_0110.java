package com.hhb.algorithm.leetcode;

/**
 * @author hhb
 * @date 2022/6/6
 * @description110. 平衡二叉树 https://leetcode.cn/problems/balanced-binary-tree/
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question_0110 {


    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDepth(root) <= 1;
    }

    public static int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left) + 1;
        int right = getDepth(node.right) + 1;
        return Math.abs(left - right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode5.left = treeNode6;
        System.err.println(isBalanced(treeNode1));

    }
}
