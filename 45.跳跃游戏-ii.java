/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int count = 0, curRange = 0, maxRange = 0;
        for (int i = 0; i <= curRange && curRange < nums.length - 1; i++) {
            // 此次跳跃所能达到的最大距离
            maxRange = Math.max(maxRange, nums[i] + i);
            if (i == curRange) {
                curRange = maxRange;
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
