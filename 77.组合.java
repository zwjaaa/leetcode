/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k);
        return result;
    }

    public void backtracking(int i, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
        }
        for (; i <= n; i++) {
            // 剪枝，可选元素数量为n-i+1，若需要添加的元素个数大于可选则不需再看
            if (k > n - i + 1)
                return;
            path.add(i);
            backtracking(i + 1, n, k - 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
