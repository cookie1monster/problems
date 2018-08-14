package org.problems.dp;

//https://leetcode.com/problems/super-egg-drop/description/
public class SuperEggDrop2 {

    //if it not breaks (K, N-X), or it breaks and we have state (K-1, X-1).
    private static int superEggDrop(int K, int N, int[][] dp) {
        if (K <= 1 || N <= 1)
            return N;

        if (dp[K][N] > 0)
            return dp[K][N];

        int min = N;
        int lo = 1;
        int hi = N;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int state1 = superEggDrop(K, N - mid, dp);
            int state2 = superEggDrop(K - 1, mid - 1, dp);
            min = Math.min(min, 1 + Math.max(state1, state2));
            if (state1 == state2)
                break;
            if (state1 > state2)
                lo = mid + 1;
            else
                hi = mid;
        }
        dp[K][N] = min;
        return min;
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
