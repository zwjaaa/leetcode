/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        Lock
        int left = 0, right = x, ans = -1, mid;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;

    }
}
// @lc code=end
