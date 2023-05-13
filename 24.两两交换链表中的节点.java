/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(-1, head), cursor = result, temp1, temp2;
        while (cursor.next != null && cursor.next.next != null) {
            temp1 = cursor.next;
            temp2 = cursor.next.next;
            temp1.next = temp2.next;
            temp2.next = temp1;
            cursor.next = temp2;
            cursor = cursor.next.next;
        }
        return result.next;
    }
}
// @lc code=end
