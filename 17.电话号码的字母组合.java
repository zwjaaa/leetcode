/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    char[] arr;
    int len;
    String[] numberMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        len = digits.length();
        arr = new char[len];
        for (int i = 0; i < len; i++) {
            arr[i] = digits.charAt(i);
        }
        backtracking(0);
        return result;
    }

    public void backtracking(int i) {
        if (i >= len) {
            if (sb.length() > 0)
                result.add(sb.toString());
            return;
        }
        String s = numberMap[arr[i] - '0'];
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            sb.append(c);
            backtracking(i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end
