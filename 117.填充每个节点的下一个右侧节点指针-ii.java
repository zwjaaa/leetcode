/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Deque<Node> queue = new LinkedList<>();
        int size;
        Node cur = root;
        queue.addLast(cur);
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.removeFirst();
                if (i < size - 1) {
                    cur.next = queue.peekFirst();
                } else {
                    cur.next = null;
                }
                if (cur.left != null)
                    queue.addLast(cur.left);
                if (cur.right != null)
                    queue.addLast(cur.right);
            }
        }
        return root;
    }
}
// @lc code=end
