package org.problems.dp;

//https://leetcode.com/problems/unique-binary-search-trees/description/
public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
    }
}
