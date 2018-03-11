package org.problems.dp;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/longest-valid-parentheses/description/
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.addFirst(i);
            } else {
                stack.pollFirst();
                if (stack.isEmpty()) {
                    stack.addFirst(i);
                } else {
                    result = Math.max(result, i - stack.peekFirst());
                }
            }
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
