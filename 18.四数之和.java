/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start

import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
            if (i > 0 && nums[i - 1] == nums[i]) { // 对nums[i]去重
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) { // 对nums[j]去重
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    // nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对nums[left]和nums[right]去重
                        while (right > left && nums[right] == nums[right - 1])
                            right--;
                        while (right > left && nums[left] == nums[left + 1])
                            left++;

                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int i = l, j = r, pivot = nums[l];
        while (i < j) {
            while (i < j && nums[j] > pivot)
                j--;
            if (i < j)
                nums[i++] = nums[j];
            while (i < j && nums[i] <= pivot)
                i++;
            if (i < j)
                nums[j--] = nums[i];

        }
        nums[i] = pivot;
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

}
// @lc code=end
