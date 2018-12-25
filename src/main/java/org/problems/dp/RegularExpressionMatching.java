package org.problems.dp;

//https://leetcode.com/problems/regular-expression-matching/description/
public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        isMatch(s, p, 0, 0, memo);
        return memo[0][0];
    }

    private static boolean isMatch(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null)
            return memo[i][j];

        boolean ans = false;
        if (j == p.length())
            ans = i == s.length();
        else {
            boolean firstMatch = (i < s.length() &&
                    (p.charAt(j) == s.charAt(i) ||
                            p.charAt(j) == '.'));

            if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                ans = isMatch(s, p, i, j + 2, memo) ||
                        (firstMatch && isMatch(s, p, i + 1, j, memo));
            else
                ans = firstMatch && isMatch(s, p, i + 1, j + 1, memo);

        }

        memo[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*p*.") == false);
        System.out.println(isMatch("aab", "c*a*b") == true);
        System.out.println(isMatch("ab", ".*") == true);
        System.out.println(isMatch("abcgkfsm", "ab.*c.*k.s.") == true);
        System.out.println(isMatch("aa", "a") == false);
        System.out.println(isMatch("aa", "a*") == true);
    }
}
