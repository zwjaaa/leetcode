/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    TreeNode pre = null;
    int minDiff = Integer.MAX_VALUE, diff;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        inorderTraversal(root);
        return minDiff;
    }

    public void inorderTraversal(TreeNode cur) {
        if (cur == null)
            return;
        inorderTraversal(cur.left);
        if (pre != null && cur.val - pre.val < minDiff) {
            minDiff = cur.val - pre.val;
        }
        pre = cur;
        inorderTraversal(cur.right);
    }

}
// @lc code=end
