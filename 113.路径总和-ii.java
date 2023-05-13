/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start

import java.util.ArrayList;
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<Integer> pathList = new ArrayList<>();
        preOrderDFS(root, targetSum, result, pathList);
        return result;
    }

    public static void preOrderDFS(TreeNode cur, int targetSum, List<List<Integer>> result, List<Integer> pathList) {
        pathList.add(cur.val);
        if (cur.left == null && cur.right == null) {
            if (targetSum == cur.val) {
                result.add(new ArrayList<>(pathList));
            }
            return;
        }
        if (cur.left != null) {
            preOrderDFS(cur.left, targetSum - cur.val, result, pathList);
            pathList.remove(pathList.size() - 1);
        }
        if (cur.right != null) {
            preOrderDFS(cur.right, targetSum - cur.val, result, pathList);
            pathList.remove(pathList.size() - 1);
        }
    }
}
// @lc code=end
