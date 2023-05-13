/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = 0;
        while (start < len) {
            int travel = 0;
            for (int i = 0; i < len; i++) {
                int rest = gas[(start + i) % len] - cost[(start + i) % len];
                travel += rest;
                if (travel < 0) {
                    start += i;
                    break;
                }
            }
            if (travel >= 0) {
                return start;
            }
            start++;
        }
        return -1;
    }
}
// @lc code=end
