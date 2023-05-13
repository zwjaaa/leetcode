/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 */

// @lc code=start

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    /*
     * 给出二叉 搜索 树的根节点，
     * 该树的节点值各不相同，
     * 请你将其转换为累加树（Greater Sum Tree），
     * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     */
    int sum;

    public TreeNode convertBST(TreeNode root) {
        // 计算出BST元素的总和
        sum = getSum(root);
        traversal(root);
        return root;
    }

    public int getSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }

    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        int temp = root.val;
        root.val = sum;
        sum -= temp;
        traversal(root.right);
    }

}
// @lc code=end
