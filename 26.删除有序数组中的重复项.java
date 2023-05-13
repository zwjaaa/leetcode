/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int step = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev)
                step++;
            prev = nums[i];
            nums[i - step] = nums[i];
        }
        return nums.length - step;
    }
}
// @lc code=end
