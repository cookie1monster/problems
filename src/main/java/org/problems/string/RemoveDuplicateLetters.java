package org.problems.string;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/remove-duplicate-letters/description/
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ++i)
            ++freq[s.charAt(i) - 'a'];

        boolean[] inStack = new boolean[26];
        for (int i = 0; i < s.length(); ++i) {
            if (!inStack[s.charAt(i) - 'a']) {
                while (!stack.isEmpty() && s.charAt(i) <= stack.peekLast() && freq[stack.peekLast() - 'a'] > 0) {
                    inStack[stack.pollLast() - 'a'] = false;
                }
                stack.addLast(s.charAt(i));
                inStack[s.charAt(i) - 'a'] = true;
            }
            --freq[s.charAt(i) - 'a'];
        }

        char[] res = new char[stack.size()];
        int i = 0;
        for (char ch : stack) {
            res[i++] = ch;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println("bcd".equals(removeDuplicateLetters("bddbccd")));
        System.out.println("abc".equals(removeDuplicateLetters("abacb")));
        System.out.println("abc".equals(removeDuplicateLetters("bcabc")));
        System.out.println("acdb".equals(removeDuplicateLetters("cbacdcbc")));
        System.out.println("abdc".equals(removeDuplicateLetters("aacbbbdc")));
    }
}
