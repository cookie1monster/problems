package org.problems.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/remove-invalid-parentheses/description/
public class RemoveInvalidParentheses {

    private static int findInvalidParentheses(String s) {
        int open = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                ++open;
            else if (s.charAt(i) == ')') {
                if (open == 0)
                    return i;
                --open;
            }
        }
        if (open == 0)
            return -1;

        int close = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ')')
                ++close;
            else if (s.charAt(i) == '(') {
                if (close == 0)
                    return i;
                --close;
            }
        }
        return -1;
    }

    private static void removeInvalidParentheses(String s, Set<String> valid, Set<String> invalid) {
        if (!valid.isEmpty() && s.length() < valid.iterator().next().length() || valid.contains(s) || invalid.contains(s))
            return;
        int index = findInvalidParentheses(s);
        if (index == -1) {
            if (valid.isEmpty() || s.length() == valid.iterator().next().length())
                valid.add(s);
            else if (!valid.isEmpty() && s.length() > valid.iterator().next().length()) {
                valid.clear();
                valid.add(s);
            }
            return;
        }
        invalid.add(s);
        if (s.charAt(index) == '(') {
            int to = index - 1;
            while (to > 0 && s.charAt(to) != ')')
                --to;
            to = Math.max(to, 0);
            for (int i = s.length() - 1; i >= to; --i) {
                if (s.charAt(i) != s.charAt(index) || (i > 0 && s.charAt(i) == s.charAt(i - 1)))
                    continue;
                removeInvalidParentheses(s.substring(0, i) + s.substring(i + 1), valid, invalid);
            }
        } else {
            int to = index;
            while (to < s.length() && s.charAt(to) != '(')
                ++to;
            to = Math.min(to, s.length() - 1);
            for (int i = 0; i <= to; ++i) {
                if (s.charAt(i) != s.charAt(index) || (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)))
                    continue;
                removeInvalidParentheses(s.substring(0, i) + s.substring(i + 1), valid, invalid);
            }
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() && sb.charAt(i) != '(') {
            if (sb.charAt(i) == ')')
                sb.delete(i, i + 1);
            else
                ++i;
        }

        i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) != ')') {
            if (sb.charAt(i) == '(')
                sb.delete(i, i + 1);
            --i;
        }

        Set<String> valid = new HashSet<>();
        removeInvalidParentheses(sb.toString(), valid, new HashSet<>());
        return new ArrayList<>(valid);
    }

    public static void main(String[] args) {

        System.out.println(removeInvalidParentheses("()((((()"));
        System.out.println(removeInvalidParentheses("((())))((())m)(()()"));
        System.out.println(removeInvalidParentheses("((()))((()(()"));
        System.out.println(removeInvalidParentheses(")k)(p(((())((j("));
        System.out.println(removeInvalidParentheses("))n((i()"));
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses("(a)())()"));
    }
}
