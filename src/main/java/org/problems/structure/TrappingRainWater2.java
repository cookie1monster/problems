package org.problems.structure;

import java.util.PriorityQueue;

//https://leetcode.com/problems/trapping-rain-water-ii/description/
public class TrappingRainWater2 {

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap.length < 2 || heightMap[0].length < 2)
            return 0;

        int rows = heightMap.length;
        int cols = heightMap[0].length;

        PriorityQueue<int[]> que = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; ++i) {
            que.offer(new int[]{i, 0, heightMap[i][0]});
            visited[i][0] = true;

            que.offer(new int[]{i, cols - 1, heightMap[i][cols - 1]});
            visited[i][cols - 1] = true;
        }

        for (int j = 0; j < cols; ++j) {
            que.offer(new int[]{0, j, heightMap[0][j]});
            visited[0][j] = true;

            que.offer(new int[]{rows - 1, j, heightMap[rows - 1][j]});
            visited[rows - 1][j] = true;
        }


        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int water = 0;
        while (!que.isEmpty()) {
            int[] cell = que.poll();
            for (int[] dir : directions) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x > 0 && y > 0 && x < rows - 1 && y < cols - 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    water += Math.max(0, cell[2] - heightMap[x][y]);
                    que.offer(new int[]{x, y, Math.max(cell[2], heightMap[x][y])});
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {

        System.out.println(trapRainWater(new int[][]{
                {9, 9, 9, 9, 9, 9, 8, 9, 9, 9, 9},
                {9, 0, 0, 0, 0, 0, 1, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}}) == 215);

        System.out.println(trapRainWater(new int[][]{
                {2, 2, 2},
                {2, 1, 2},
                {2, 1, 2},
                {2, 1, 2}}) == 0);

        System.out.println(trapRainWater(new int[][]{
                {1, 3, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 3},
                {3, 3, 3, 2, 3, 1}}) == 4);

        System.out.println(trapRainWater(new int[][]{
                {5, 5, 5, 1},
                {5, 1, 1, 5},
                {5, 1, 5, 5},
                {5, 2, 5, 8}}) == 3);

        System.out.println(trapRainWater(new int[][]{
                {9, 9, 9, 9, 9},
                {9, 2, 1, 2, 9},
                {9, 2, 8, 2, 9},
                {9, 2, 3, 2, 9},
                {9, 9, 9, 9, 9}}) == 57);

        System.out.println(trapRainWater(new int[][]{
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}}) == 4);
    }

}
