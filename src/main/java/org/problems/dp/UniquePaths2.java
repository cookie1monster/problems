package org.problems.dp;

//https://leetcode.com/problems/unique-paths-ii/description/
public class UniquePaths2 {

    public static int uniquePaths(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 || obstacleGrid[0][0] == 1
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (obstacleGrid[i][j] == 1 && !(i == 0 && j == 0)) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (i > 0)
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                if (j > 0)
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(new int[][]{
                {0, 0}, {1, 0}}));
        System.out.println(uniquePaths(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}}));

    }
}
