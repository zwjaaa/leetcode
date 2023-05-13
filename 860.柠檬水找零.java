/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cash[] = new int[3];
        Arrays.fill(cash, 0);

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                cash[0]++;
            } else if (bills[i] == 10) {
                cash[1]++;
                if (cash[0] > 0) {
                    cash[0]--;
                } else {
                    return false;
                }
            } else {
                cash[2]++;
                if (cash[0] > 0 && cash[1] > 0) {
                    cash[0]--;
                    cash[1]--;
                } else if (cash[0] > 2) {
                    cash[0] = cash[0] - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
