/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return result;
    }

    // start开始的位置 pointNum当前逗号数量
    public void backtracking(String s, int start, int pointNum) {
        int len = s.length();
        if (pointNum == 3) {
            if (isValidIPField(s, start, len)) {
                result.add(s);
            }
            return;
        }
        for (int i = start + 1; i <= len; i++) {
            // 剪枝
            if (!isValidIPField(s, start, i))
                return;
            s = s.substring(0, i) + "." + s.substring(i);
            // 多了个点号，下个起始位置要+1
            backtracking(s, i + 1, pointNum + 1);
            s = s.substring(0, i) + s.substring(i + 1);
        }
    }

    // 判断是否是合法的ip分段，区间左开右闭
    public boolean isValidIPField(String s, int start, int end) {
        if (start >= end)
            return false;
        s = s.substring(start, end);
        if (s == null
                || (s.length() > 1 && s.charAt(0) == '0')
                || s.length() == 0 || s.length() > 3)
            return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}
// @lc code=end
