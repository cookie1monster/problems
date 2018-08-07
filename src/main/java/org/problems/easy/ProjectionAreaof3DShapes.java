package org.problems.easy;

//https://leetcode.com/contest/weekly-contest-96/problems/projection-area-of-3d-shapes/
public class ProjectionAreaof3DShapes {

    public static int projectionArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] != 0)
                    ++res;

        for (int j = 0; j < grid[0].length; ++j) {
            int iPers = 0;
            for (int i = 0; i < grid.length; ++i)
                iPers = Math.max(iPers, grid[i][j]);
            res += iPers;
        }
        for (int i = 0; i < grid.length; ++i) {
            int jPers = 0;
            for (int j = 0; j < grid[0].length; ++j)
                jPers = Math.max(jPers, grid[i][j]);
            res += jPers;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(projectionArea(new int[][]{{2}}));
        System.out.println(projectionArea(new int[][]{{1, 0}, {0, 2}}));
        System.out.println(projectionArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
