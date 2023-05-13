/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        backtracking(1, k, n);
        return result;
    }

    public void backtracking(int i, int k, int n) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(path));
        }
        for (; i < 10; i++) {
            // 剪枝
            if (n - i < 0 || k < 0) {
                return;
            }
            path.add(i);
            backtracking(i + 1, k - 1, n - i);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
