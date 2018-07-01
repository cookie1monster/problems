package org.problems.graph;

import java.util.Arrays;

//https://leetcode.com/problems/01-matrix/description/
public class OneMatrix2 {


    public static int[][] updateMatrix(int[][] matrix) {
        int[][] dist = new int[matrix.length][matrix[0].length];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE - 10000);

        for (int i = 0; i < dist.length; ++i) {
            for (int j = 0; j < dist[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        for (int i = dist.length - 1; i >= 0; --i) {
            for (int j = dist[0].length - 1; j >= 0; --j) {
                if (i < dist.length - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < dist[0].length - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] matrix = updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        //int[][] matrix = updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        //int[][] matrix = updateMatrix(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}});
        for (int i = 0; i < matrix.length; ++i)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
