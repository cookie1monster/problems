package org.problems.string;

import java.util.Scanner;

public class LengthOfLongestPalindromeSubstring {

    static String longestCommonSubstring(String s1, String s2) {
        int L[][] = new int[s1.length() + 1][s2.length() + 1];
        int result = 0;
        int index = 0;
        for (int i=1; i<=s1.length(); i++) {
            for (int j=1; j<=s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                    if (result <= L[i][j] && s2.length() - i + L[i][j] == j) {
                        result = L[i][j];
                        index = j;
                    }
                }
            }
        }
        return result == 0 ? "" : s2.substring(index - result, index);
    }

    static String longestPalindrome(String s) {
        return longestCommonSubstring(s, new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(longestPalindrome(s));
    }
}
