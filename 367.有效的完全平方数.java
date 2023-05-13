/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num, ans = -1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long) mid * mid <= num) {
                ans = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return ans * ans == num;
    }
}
// @lc code=end
