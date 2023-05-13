/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // 剪去多余的空格
        StringBuilder sb = trim(s);
        // 反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        // 反转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    public static StringBuilder trim(String s) {
        StringBuilder sb = new StringBuilder();
        int l = 0, r = s.length() - 1;
        while (s.charAt(l) == ' ') {
            l++;
        }
        while (s.charAt(r) == ' ') {
            r--;
        }
        while (l <= r) {
            sb.append(s.charAt(l));
            if (s.charAt(l) == ' ') {
                while (s.charAt(l) == ' ') {
                    l++;
                }
            } else {
                l++;

            }
        }
        return sb;
    }

    public static void reverse(StringBuilder sb, int l, int r) {
        char temp;
        while (l < r) {
            temp = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, temp);
        }
    }

    public static void reverseEachWord(StringBuilder sb) {
        int l = 0, r = 0, len = sb.length();
        while (l < len) {
            r = l;
            while (r < len && sb.charAt(r) != ' ') {
                r++;
            }
            reverse(sb, l, r - 1);
            l = r + 1;
        }
    }

}
// @lc code=end
