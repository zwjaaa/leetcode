/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE, curLen = 0;
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                curLen = (end - start + 1);
                minLen = (minLen > curLen) ? curLen : minLen;
                sum -= nums[start++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }
}
// @lc code=end
