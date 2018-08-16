package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/cherry-pickup/description/
public class CherryPickup2 {

    public static int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][] memo = new int[N][N][N];
        for (int[][] layer : memo)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);
        memo[N - 1][N - 1][N - 1] = grid[N - 1][N - 1];
        return Math.max(0, dp(grid, memo, 0, 0, 0));
    }

    private static int dp(int[][] grid, int[][][] memo, int f1, int f2, int s1) {
        int s2 = f1 + f2 - s1;
        int N = grid.length;
        if (f1 == N || f2 == N || s1 == N || s2 == N || grid[f1][f2] == -1 || grid[s1][s2] == -1)
            return Integer.MIN_VALUE + 1;
        if (memo[f1][f2][s1] != Integer.MIN_VALUE)
            return memo[f1][f2][s1];

        int res = grid[f1][f2];
        if (f1 != s1) res += grid[s1][s2];
        res += Math.max(
                Math.max(dp(grid, memo, f1 + 1, f2, s1), dp(grid, memo, f1, f2 + 1, s1)),
                Math.max(dp(grid, memo, f1 + 1, f2, s1 + 1), dp(grid, memo, f1, f2 + 1, s1 + 1)));

        memo[f1][f2][s1] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1}}));
        System.out.println(cherryPickup(new int[][]{
                {1, 1, -1, 1, 1},
                {-1, 1, 1, 1, 1},
                {1, -1, -1, 1, 1},
                {1, -1, 1, 1, -1},
                {1, 1, 1, -1, 1}}));
        System.out.println(cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
    }
}
