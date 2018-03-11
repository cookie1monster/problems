package org.problems.dp;

//https://leetcode.com/problems/longest-valid-parentheses/description/
public class LongestValidParentheses2 {

    public static int maxValidParentheses(String s, int start) {
        int open = 0;
        int result = 0;
        for (int i = start; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (open > 0) {
                open--;
                if (open == 0) {
                    result = i - start + 1;
                }
            } else {
                return result;
            }
        }
        return result;
    }

    public static int longestValidParentheses(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1 - result; ++i) {
            if (s.charAt(i) == ')')
                continue;
            result = Math.max(result, maxValidParentheses(s, i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(((())))"));
        System.out.println(longestValidParentheses(")(((((()())()()))()(()))("));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("()"));
    }
}
