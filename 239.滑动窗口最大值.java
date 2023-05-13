/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k - 1; i++) {
            queue.push(nums[i]);
        }
        for (; num < len; num++) {
            queue.push(nums[k + num - 1]);
            res[num] = queue.peek();
            queue.poll(nums[num]);
        }
        return res;
    }

    private class MyQueue {
        private Deque<Integer> queue;

        public MyQueue() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            while (queue.size() > 0 && queue.peekLast() < x) {
                queue.pollLast();
            }
            queue.addLast(x);
        }

        public void poll(int x) {
            if (queue.size() > 0 && queue.peekFirst() == x) {
                queue.pollFirst();
            }
        }

        public int peek() {
            return queue.peekFirst();
        }
    }
}
// @lc code=end
