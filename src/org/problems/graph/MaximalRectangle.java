package org.problems.graph;

//https://leetcode.com/problems/maximal-rectangle/description/
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 1; j < dp[0].length; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                int min = Integer.MAX_VALUE;
                for (int l = j + 1; l < dp[0].length; ++l) {
                    if (dp[i][l] == 0)
                        break;
                    min = Math.min(min, dp[i][l]);
                    result = Math.max(result, min * (l - j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][] { { '1' } }));
    }
}
