/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head), cursor = dummy, temp;
        while (cursor != null) {
            temp = cursor.next;
            while (temp != null && temp.val == val)
                temp = temp.next;
            cursor.next = temp;
            cursor = cursor.next;
        }
        return dummy.next;
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, n - 1);
        reverse(sb, n, sb.length() - 1);
        reverse(sb, 0, sb.length() - 1);
        return sb.toString();
    }

    public static void reverse(StringBuilder sb, int l, int r) {
        char temp;
        while (l < r && l >= 0 && r < sb.length()) {
            temp = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, temp);
        }
    }
}
// @lc code=end
