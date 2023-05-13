/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length, l, r;
        for (int i = 0; i < len; i += (k * 2)) {
            l = i;
            r = Math.min(len - 1, i + k - 1);
            while (l < r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        return new String(arr);
    }

    public static void swap(char[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
// @lc code=end
