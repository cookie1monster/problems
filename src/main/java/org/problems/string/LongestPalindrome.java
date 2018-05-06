package org.problems.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-palindrome/description/
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        int result = 0;
        boolean odd = false;
        for (int freqVal : freq.values()) {
            result += freqVal;
            if (freqVal % 2 == 1) {
                --result;
                odd = true;
            }
        }
        if (odd)
            ++result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("aa"));
        System.out.println(longestPalindrome("ab"));
    }
}
