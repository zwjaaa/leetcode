/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
 */

// @lc code=start

import java.text.DecimalFormat;
import java.util.ArrayList;
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> queue = new LinkedList<>();
        int size;
        double sum;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                root = queue.removeFirst();
                sum += root.val;
                if (root.left != null)
                    queue.addLast(root.left);
                if (root.right != null)
                    queue.addLast(root.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
// @lc code=end
