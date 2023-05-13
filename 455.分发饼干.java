/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int foodIndex = 0, childIndex = 0;
        while (foodIndex < s.length && childIndex < g.length) {
            if (s[foodIndex] >= g[childIndex]) {
                childIndex++;
            }
            foodIndex++;
        }
        return childIndex;
    }
}
// @lc code=end
