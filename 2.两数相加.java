/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), tail = head;
        int temp = 0, carry = 0; // temp为当前位运算的结果，carry为携带的进位
        while (l1 != null || l2 != null || carry == 1) {
            temp = carry;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode(temp % 10);
            tail = tail.next;
            carry = temp >= 10 ? 1 : 0;
        }
        return head.next;
    }
}
// @lc code=end
