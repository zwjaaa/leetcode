/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        long revers = 0;
        int num = x;
        while (num != 0) {
            revers = revers * 10 + num % 10;
            num /= 10;
        }
        return x == revers;
    }
}
// @lc code=end
