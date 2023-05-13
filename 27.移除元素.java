/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int quick = 0; quick < nums.length; quick++) {
            if (nums[quick] != val)
                nums[slow++] = nums[quick];
        }
        return slow;
    }
}
// @lc code=end
