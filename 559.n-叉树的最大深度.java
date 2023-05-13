/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int depth = 0;

        for (Node node : root.children) {
            depth = Math.max(depth, maxDepth(node));
        }

        return depth + 1;
    }
}
// @lc code=end
