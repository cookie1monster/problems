package org.problems.dp;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//https://leetcode.com/problems/valid-parentheses/description/
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        Map<Character, Character> openParentheses = new HashMap<>();
        openParentheses.put(')', '(');
        openParentheses.put('}', '{');
        openParentheses.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.addFirst(ch);
            else {
                char open = openParentheses.get(ch);
                if (stack.isEmpty() || stack.peekFirst() != open)
                    return false;
                stack.pollFirst();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
}
