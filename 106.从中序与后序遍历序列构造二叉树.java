/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
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
    int postorderIndex;
    int[] postorder;
    int[] inOrder;
    // 保存中序遍历<值,下标>
    Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();

    public TreeNode helper(int inOrderLeft, int inOrderRight) {
        // 递归出口
        if (inOrderLeft > inOrderRight)
            return null;
        int rootVal = postorder[postorderIndex--];
        int inOrderIndex = inOrderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        // 每次都先构造右子树，这样后序的下标每次都是右子树的根
        root.right = helper(inOrderIndex + 1, inOrderRight);
        root.left = helper(inOrderLeft, inOrderIndex - 1);
        return root;
    }

    public TreeNode buildTree(int[] inOrder, int[] postorder) {
        this.postorder = postorder;
        this.inOrder = inOrder;
        // 根节点为后序遍历的最后一个元素
        this.postorderIndex = postorder.length - 1;
        // 建立中序遍历map
        int index = 0;
        for (int value : inOrder) {
            inOrderMap.put(value, index++);
        }
        return helper(0, index - 1);
    }
}
// @lc code=end