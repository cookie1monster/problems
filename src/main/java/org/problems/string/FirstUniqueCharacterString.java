package org.problems.string;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/first-unique-character-in-a-string/description/
public class FirstUniqueCharacterString {

    private static final int SHIFT = 97;

    public static int firstUniqChar1(String s) {
        int[] alphabet = new int[26];
        Deque<Character> stack = new LinkedList<>();
        for (int i = s.length() - 1; i >= 0; --i) {
            if (alphabet[s.charAt(i) - SHIFT] == 0) {
                stack.addFirst(s.charAt(i));
            }
            alphabet[s.charAt(i) - SHIFT]++;
        }
        while (stack.size() > 0) {
            char ch = stack.pollFirst();
            if (alphabet[ch - SHIFT] == 1) {
                return s.indexOf(ch);
            }
        }

        return -1;
    }

    public static int firstUniqChar(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            frequency[s.charAt(i) - SHIFT]++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency[s.charAt(i) - SHIFT] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aac"));
        System.out.println(firstUniqChar("leetcode"));
    }
}
