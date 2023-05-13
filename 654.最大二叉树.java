/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }

    public TreeNode build(int left, int right) {
        if (left > right)
            return null;
        int maxIndex = findMaxIndex(left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        // 最大元素左侧为左子树，右侧为右子树
        root.left = build(left, maxIndex - 1);
        root.right = build(maxIndex + 1, right);
        return root;
    }

    // 找到当前范围内最大元素的下标
    public int findMaxIndex(int left, int right) {
        int max = nums[left], index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

}
// @lc code=end
