package org.problems.easy;

//https://leetcode.com/problems/surface-area-of-3d-shapes/description/
public class SurfaceAreaof3DShapes {

    public static int surfaceArea(int[][] grid) {
        if (grid.length < 1) return 0;
        int surface = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) continue;
                surface += 2;
                if (i == 0) surface += grid[i][j];
                if (j == 0) surface += grid[i][j];
                if (i == grid.length - 1) surface += grid[i][j];
                if (j == grid[0].length - 1) surface += grid[i][j];


                if (i > 0 && grid[i - 1][j] < grid[i][j]) surface += grid[i][j] - grid[i - 1][j];
                if (j > 0 && grid[i][j - 1] < grid[i][j]) surface += grid[i][j] - grid[i][j - 1];

                if (i < grid.length - 1 && grid[i + 1][j] < grid[i][j]) surface += grid[i][j] - grid[i + 1][j];
                if (j < grid[0].length - 1 && grid[i][j + 1] < grid[i][j]) surface += grid[i][j] - grid[i][j + 1];
            }
        }
        return surface;
    }

    public static void main(String[] args) {
        System.out.println(surfaceArea(new int[][]{{2}}));
        System.out.println(surfaceArea(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
        System.out.println(surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));

    }
}
