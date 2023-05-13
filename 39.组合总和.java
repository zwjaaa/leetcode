/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> chosenList = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        backtracking(0, target);
        return result;
    }

    public void backtracking(int i, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(chosenList));
        }
        for (; i < candidates.length; i++) {
            if (target - candidates[i] < 0)
                return;
            chosenList.add(candidates[i]);
            backtracking(i, target - candidates[i]);
            chosenList.remove(chosenList.size() - 1);
        }
    }
}
// @lc code=end
