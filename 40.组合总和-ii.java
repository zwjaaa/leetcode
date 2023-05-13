/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> chosenList = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;

        backtracking(0, target);
        System.out.println(Arrays.toString(candidates));
        return result;
    }

    public void backtracking(int i, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(chosenList));
        }
        for (int k = i; k < candidates.length; k++) {
            if (target - candidates[i] < 0)
                return;
            // 相同的元素，我们只递归第一个
            if (k > i && candidates[k] == candidates[k - 1]) {
                continue;
            }
            chosenList.add(candidates[k]);
            backtracking(k + 1, target - candidates[k]);
            chosenList.remove(chosenList.size() - 1);
        }
    }
}
// @lc code=end
