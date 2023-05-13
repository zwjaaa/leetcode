/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    /**
     * 遇到数字，压入数栈
     * 遇到运算符，先后取出b、a，计算出c=(a运算符b)并压入数栈
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> numberStack = new LinkedList<>();
        int a, b;
        String s;
        for (int i = 0; i < tokens.length; i++) {
            s = tokens[i];
            if (isNumber(s)) {
                numberStack.addFirst(Integer.parseInt(s));
            } else {
                b = numberStack.pollFirst();
                a = numberStack.pollFirst();
                numberStack.addFirst(calculate(a, b, s));
            }
        }
        return numberStack.pollFirst();
    }

    public static boolean isNumber(String s) {
        return !(s.equals("+")
                || s.equals("-")
                || s.equals("*")
                || s.equals("/"));
    }

    public static int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return -1;
        }
    }
}
// @lc code=end
