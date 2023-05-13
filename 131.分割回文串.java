/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> splits = new ArrayList<>();
    String s;
    int len;

    public List<List<String>> partition(String s) {
        this.s = s;
        len = s.length();
        backtracking(0, len);
        return result;
    }

    public void backtracking(int l, int r) {
        if (l >= r)
            result.add(new ArrayList<>(splits));

        for (int i = l + 1; i <= r; i++) {
            if (!isPalindrome(l, i))
                continue;
            splits.add(s.substring(l, i));
            backtracking(i, r);
            splits.remove(splits.size() - 1);
        }
    }

    public boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(--r))
                return false;
        }
        return true;
    }
}
// @lc code=end
