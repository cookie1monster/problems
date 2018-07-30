package org.problems.dp;

//https://leetcode.com/problems/count-different-palindromic-subsequences/description/
public class CountDifferentPalindromicSubsequences {

    public static int countPalindromicSubsequences(String S) {
        int M = 1000000007;
        int n = S.length();
        char[] arr = S.toCharArray();
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; ++i)
            dp[i][i] = 1;

        for (int len = 1; len < n; ++len) {
            for (int lo = 0, hi = len; hi < n; ++lo, ++hi) {
                if (arr[lo] == arr[hi]) {
                    char ch = arr[lo];
                    int leftIdx = lo + 1, rightIdx = hi - 1;
                    while (leftIdx <= rightIdx && ch != S.charAt(leftIdx))
                        leftIdx++;

                    while (leftIdx <= rightIdx && ch != S.charAt(rightIdx))
                        rightIdx--;

                    dp[lo][hi] = 2 * dp[lo + 1][hi - 1];
                    /*
                        consider the string from i to j is "a...a" "a...a"... where there is no character 'a' inside the leftmost and rightmost 'a'
                        eg:  "aba" while i = 0 and j = 2:  dp[1][1] = 1 records the palindrome{"b"},
                        the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"b"},
                        and additional time as {"aba"}. The reason why 2 counted is that we also count {"a", "aa"}.
                        So totally dp[i][j] record the palindrome: {"a", "b", "aa", "aba"}.
                    */
                    if (leftIdx > rightIdx) {
                        dp[lo][hi] += 2;
                    }
                    /*
                        consider the string from i to j is "a...a...a" where there is only one character 'a' inside the leftmost and rightmost 'a'
                        eg:  "aaa" while i = 0 and j = 2: the dp[i + 1][j - 1] records the palindrome {"a"}.
                        the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"a"},
                        and additional time as {"aaa"}. the reason why 1 counted is that
                        we also count {"aa"} that the first 'a' come from index i and the second come from index j. So totally dp[i][j] records {"a", "aa", "aaa"}
                    */
                    else if (leftIdx == rightIdx) {
                        dp[lo][hi] += 1;
                    }
                    /*
                        consider the string from i to j is "a...a...a... a" where there are at least two character 'a' close to leftmost and rightmost 'a'
                        eg: "aacaa" while i = 0 and j = 4: the dp[i + 1][j - 1] records the palindrome {"a",  "c", "aa", "aca"}.
                        the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"a",  "c", "aa", "aca"},
                        and additional time as {"aaa",  "aca", "aaaa", "aacaa"}.  Now there is duplicate :  {"aca"},
                        which is removed by deduce dp[low + 1][high - 1]. So totally dp[i][j] record {"a",  "c", "aa", "aca", "aaa", "aaaa", "aacaa"}
                    */
                    else {
                        dp[lo][hi] -= dp[leftIdx + 1][rightIdx - 1];
                    }

                } else {
                    dp[lo][hi] = dp[lo][hi - 1] + dp[lo + 1][hi] - dp[lo + 1][hi - 1];
                }

                dp[lo][hi] = (dp[lo][hi] + M) % M;
            }
        }
        return (int) dp[0][n - 1];
    }

    public static void main(String[] args) {

        System.out.println(countPalindromicSubsequences("bddaabdbbccdcdcbbdbddccbaaccabbcacbadbdadbccddccdbdbdbdabdbddcccadddaaddbcbcbabdcaccaacabdbdaccbaacc") == 744991227);
        System.out.println(countPalindromicSubsequences("bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbdaada") == 117990582);
        System.out.println(countPalindromicSubsequences("bccb") == 6);
    }
}
