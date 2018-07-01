package org.problems.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/01-matrix/description/
public class OneMatrix {

    private static void bfs(int[][] matrix, int i, int j, boolean[][] visited) {
        Deque<int[]> toVisit = new LinkedList<>();
        toVisit.addLast(new int[]{i, j, 0});
        while (!toVisit.isEmpty()) {
            int[] cell = toVisit.pollFirst();
            int x = cell[0];
            int y = cell[1];
            int dist = cell[2];
            if ((matrix[x][y] == 0 && !visited[cell[0]][cell[1]]) || (matrix[x][y] > dist + 1)) {
                if (matrix[x][y] == 0) {
                    visited[x][y] = true;
                    dist = 0;
                } else {
                    dist += 1;
                    matrix[x][y] = Math.min(matrix[x][y], dist);
                }
                if (x + 1 < matrix.length && !visited[x + 1][y])
                    toVisit.addLast(new int[]{x + 1, y, dist});
                if (y + 1 < matrix[0].length && !visited[x][y + 1])
                    toVisit.addLast(new int[]{x, y + 1, dist});
                if (x - 1 >= 0 && !visited[x - 1][y])
                    toVisit.addLast(new int[]{x - 1, y, dist});
                if (y - 1 >= 0 && !visited[x][y - 1])
                    toVisit.addLast(new int[]{x, y - 1, dist});

            }
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] != 0)
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    bfs(matrix, i, j, visited);
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        //int[][] matrix = updateMatrix(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}});
        for (int i = 0; i < matrix.length; ++i)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
