/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (isLeftBracket(c)) {
                stack.push(c);
            } else {
                if (stack.size() == 0 || !validBracket(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isLeftBracket(char c) {
        return (c == '(' || c == '[' || c == '{');
    }

    public static boolean validBracket(char leftBracket, char rightBracket) {
        if (leftBracket == '(') {
            return rightBracket == ')';
        } else if (leftBracket == '[') {
            return rightBracket == ']';
        } else if (leftBracket == '{') {
            return rightBracket == '}';
        } else {
            return false;
        }
    }
}
// @lc code=end
