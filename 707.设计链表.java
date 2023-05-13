/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class MyLinkedList {

    private ListNode head;

    private Integer length;

    private class ListNode {

        private Integer val;

        private ListNode next;

        public ListNode() {
            val = -1;
            next = null;
        }

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public MyLinkedList() {
        head = new ListNode();
        length = 0;
    }

    public int get(int index) {
        if (index + 1 > length)
            return -1;
        ListNode cursor = head.next;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        return cursor.val;
    }

    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = head.next;
        head.next = temp;
        length++;
    }

    public void addAtTail(int val) {
        ListNode temp = new ListNode(val), cursor = head;
        while (cursor.next != null)
            cursor = cursor.next;
        cursor.next = temp;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length)
            return;
        ListNode temp = new ListNode(val), cursor = head;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        temp.next = cursor.next;
        cursor.next = temp;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length)
            return;
        ListNode cursor = head;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        cursor.next = cursor.next.next;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end
