package org.problems.string;

import java.util.Scanner;

public class LengthOfLongestPalindromeSubstring2 {

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindrome(String s, int left, int right) {
        int start = 0, end = 0;
        for (int i = left; i < right; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                if (len == s.length()) {
                    return s;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static String longestPalindrome(String s) {
        String str1 = longestPalindrome(s, Math.min(s.length(), s.length() / 2 - 1), s.length());
        if (str1.equals(s)) {
            return str1;
        }
        String str2 = longestPalindrome(s, 0, Math.min(s.length(), s.length() / 2 - 1));
        return (str1.length() > str2.length()) ? str1 : str2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(longestPalindrome(s));
    }
}
