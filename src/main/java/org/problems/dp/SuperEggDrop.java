package org.problems.dp;

//https://leetcode.com/problems/super-egg-drop/description/
public class SuperEggDrop {

    //(K, N-X), or it breaks and we have state (K-1, X-1).
    private static int superEggDrop(int K, int N, int[][] dp) {
        if (K <= 1 || N <= 1)
            return N;

        if (dp[K][N] > 0)
            return dp[K][N];

        int min = N;
        for (int i = 1; i <= N; ++i)
            min = Math.min(min, 1 + Math.max(superEggDrop(K, N - i, dp), superEggDrop(K - 1, i - 1, dp)));

        dp[K][N] = min;
        return dp[K][N];
    }

    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int res = superEggDrop(K, N, dp);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(1, 3));
        System.out.println(superEggDrop(1, 2));
        System.out.println(superEggDrop(3, 14));
        System.out.println(superEggDrop(2, 6));
    }
}
