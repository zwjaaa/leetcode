/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        if (ratings.length == 1)
            return 1;

        int candyEach[] = new int[ratings.length];
        candyEach[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candyEach[i] = ratings[i] > ratings[i - 1]
                    ? candyEach[i - 1] + 1
                    : 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyEach[i] = Math.max(candyEach[i + 1] + 1, candyEach[i]);
            }
        }
        return IntStream.of(candyEach).sum();
    }
}
// @lc code=end
