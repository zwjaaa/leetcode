/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> resultInner = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int start) {
        result.add(new ArrayList<>(resultInner));
        int len = nums.length;
        if (start >= len)
            return;
        for (int i = start; i < len; i++) {
            resultInner.add(nums[i]);
            backtracking(nums, i + 1);
            resultInner.removeLast();
        }
    }
}
// @lc code=end
