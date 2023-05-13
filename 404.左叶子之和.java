/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

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
    public int sumOfLeftLeaves(TreeNode root) {
        return getLeftChildVal(root, false);
    }

    public static int getLeftChildVal(TreeNode cur, boolean isLeftChild) {
        if (cur == null)
            return 0;
        if (isLeftChild && cur.left == null && cur.right == null)
            return cur.val;
        return getLeftChildVal(cur.left, true) + getLeftChildVal(cur.right, false);
    }
}
// @lc code=end
