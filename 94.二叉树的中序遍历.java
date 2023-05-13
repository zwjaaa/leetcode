/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            if (cur != null) { // 指针来访问节点，访问到最底层
                st.addFirst(cur); // 将访问的节点放进栈
                cur = cur.left; // 左
            } else {
                cur = st.pollFirst(); // 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
                result.add(cur.val); // 中
                cur = cur.right; // 右
            }
        }
        return result;
    }
}
// @lc code=end
