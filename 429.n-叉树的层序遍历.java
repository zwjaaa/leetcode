/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
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

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultInner;
        if (root == null)
            return result;
        Deque<Node> queue = new LinkedList<>();
        int size;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            resultInner = new ArrayList<>();
            size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.removeFirst();
                resultInner.add(root.val);
                for (int j = 0; j < root.children.size(); j++) {
                    queue.addLast(root.children.get(j));
                }
            }
            result.add(resultInner);
        }
        return result;
    }
}
// @lc code=end
