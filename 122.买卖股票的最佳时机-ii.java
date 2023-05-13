/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profitToday = prices[i] - prices[i - 1];
            if (profitToday > 0) {
                profit += profitToday;
            }
        }
        return profit;
    }
}
// @lc code=end
