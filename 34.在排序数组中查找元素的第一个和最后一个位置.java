/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        if (nums.length == 0)
            return result;
        result[0] = findFirstTargetPosition(nums, target);
        if (result[0] == -1) {
            return result;
        }
        result[1] = findLastTargetPosition(nums, target);
        return result;
    }

    private int findFirstTargetPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int findLastTargetPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = (left + right + 1) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
// @lc code=end
