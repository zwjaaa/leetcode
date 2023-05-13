/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultInner = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(cur);
        while (!queue.isEmpty()) {
            int size = queue.size();
            resultInner = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                cur = queue.removeFirst();
                resultInner.add(cur.val);
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
            result.add(resultInner);
        }
        Collections.reverse(result);
        return result;
    }
}
// @lc code=end
