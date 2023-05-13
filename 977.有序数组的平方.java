
/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = nums.length - 1, left = 0, right = nums.length - 1;
        int result[] = new int[nums.length];

        while (left <= right && i >= 0) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                result[i] = nums[right] * nums[right];
                right--;
            } else {
                result[i] = nums[left] * nums[left];
                left++;
            }
            i--;
        }

        return result;
    }
}
// @lc code=end
