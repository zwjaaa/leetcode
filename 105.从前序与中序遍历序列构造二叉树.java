/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    int[] preorder;
    int[] inorder;
    // 当前遍历的先序下标
    int preorderIndex;
    // 节点的数量
    int n;
    // 中序的<值，下标>
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode helper(int left, int right) {
        // 递归出口
        if (left > right || preorderIndex >= n)
            return null;
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = inorderMap.get(rootVal);
        // 先递归构造左子树
        root.left = helper(left, inorderIndex - 1);
        root.right = helper(inorderIndex + 1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        preorderIndex = 0;
        n = preorder.length;
        // 构建中序map
        int index = 0;
        for (int value : inorder) {
            inorderMap.put(value, index++);
        }
        return helper(0, n - 1);
    }
}
// @lc code=end
