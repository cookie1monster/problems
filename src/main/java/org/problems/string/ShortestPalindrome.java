package org.problems.string;

//https://leetcode.com/problems/shortest-palindrome/description/
public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j))
                j += 1;
        }
        if (j == s.length())
            return s;
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abaaaaaaaaacdaaabaaaaaaa"));
        System.out.println(shortestPalindrome("aaaaaaaaaaacdaaaaaaaaaaa"));
        System.out.println(shortestPalindrome("aaaaa"));
        //aababaabababababaababaa
        System.out.println(shortestPalindrome("aabababababaababaa"));
        System.out.println(shortestPalindrome("abb"));
        //ababbabbbabbaba
        System.out.println(shortestPalindrome("babbbabbaba"));
        System.out.println(shortestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome(""));
        System.out.println(shortestPalindrome("abcd"));
    }
}
