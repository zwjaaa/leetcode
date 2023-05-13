/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    static int max; // 问题规模
    static int[] solution; // 解法
    static List<List<String>> result = new ArrayList<>(); // 结果

    public List<List<String>> solveNQueens(int n) {
        result.clear();
        max = n;
        solution = new int[max];
        check(0);
        return result;
    }

    // 判断当前摆放的皇后是否有冲突
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (solution[i] == solution[n] || Math.abs(i - n) == Math.abs(solution[i] - solution[n])) {
                return false;
            }
        }
        return true;
    }

    // 摆放皇后
    public void check(int n) {
        if (n == max) {
            // 最后一个已经放完
            result.add(getList());
            return;
        }
        for (int i = 0; i < max; i++) {
            solution[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public List<String> getList() {
        List<String> list = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < solution[i]; j++) {
                temp += ".";
            }
            temp += "Q";
            for (int j = solution[i] + 1; j < max; j++) {
                temp += ".";
            }
            list.add(temp);
            temp = "";
        }
        return list;
    }
}
// @lc code=end
