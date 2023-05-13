import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum, temp;
        while (n != 1) {
            sum = 0;
            temp = n;
            while (temp > 0) {
                sum += ((temp % 10) * (temp % 10));
                temp = temp / 10;
            }
            if (set.contains(sum))
                return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }
}
// @lc code=end
