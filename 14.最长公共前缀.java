/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        int strLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            strLen = Math.min(strLen, strs[i].length());
        }
        for (int i = 0; i < strLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c)
                    return commonPrefix.toString();
            }
            commonPrefix.append(c);
        }
        return commonPrefix.toString();
    }
}
// @lc code=end
