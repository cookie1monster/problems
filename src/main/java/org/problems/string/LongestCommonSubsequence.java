package org.problems.string;

import java.util.Scanner;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(char[] s1, char[] s2, int iS1, int iS2) {
        int L[][] = new int[iS1 + 1][iS2 + 1];

        for (int i = 0; i <= iS1; i++) {
            for (int j = 0; j <= iS2; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[iS1][iS2];
    }

    public static int commonChild(String s1, String s2) {
        return longestCommonSubsequence(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}
