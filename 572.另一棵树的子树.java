/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
 */

// @lc code=start
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null && subRoot != null)
            return false;
        if (subRoot == null)
            return true;
        return traversalJudge(root, subRoot);
    }

    public static boolean traversalJudge(TreeNode cur, TreeNode subRoot) {
        if (cur == null)
            return false;
        return isSameTree(cur, subRoot)
                || traversalJudge(cur.left, subRoot)
                || traversalJudge(cur.right, subRoot);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
// @lc code=end
