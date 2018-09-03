package org.problems.structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/the-skyline-problem/description/
public class RectangleArea2 {

    public static int rectangleArea(int[][] rectangles) {
        Set<Integer> xScaleSet = new HashSet<>();
        Set<Integer> yScaleSet = new HashSet<>();
        for (int[] rect : rectangles) {
            xScaleSet.add(rect[0]);
            xScaleSet.add(rect[2]);

            yScaleSet.add(rect[1]);
            yScaleSet.add(rect[3]);
        }

        Integer[] xScale = xScaleSet.toArray(new Integer[0]);
        Integer[] yScale = yScaleSet.toArray(new Integer[0]);
        Arrays.sort(xScale);
        Arrays.sort(yScale);

        Map<Integer, Integer> xScaleMap = new HashMap<>();
        for (int i = 0; i < xScale.length; i++) {
            xScaleMap.put(xScale[i], i);
        }
        Map<Integer, Integer> yScaleMap = new HashMap<>();
        for (int i = 0; i < yScale.length; i++) {
            yScaleMap.put(yScale[i], i);
        }


        boolean[][] grid = new boolean[xScale.length][yScale.length];
        for (int[] rect : rectangles) {
            int nRow = xScaleMap.get(rect[2]);
            int nCol = yScaleMap.get(rect[3]);
            int rStart = xScaleMap.get(rect[0]);
            int cStart = yScaleMap.get(rect[1]);

            for (int r = rStart; r < nRow; ++r)
                for (int c = cStart; c < nCol; ++c)
                    grid[r][c] = true;
        }


        long ans = 0;
        for (int r = 1; r < xScale.length; ++r) {
            long scaleVal = xScale[r] - xScale[r - 1];
            for (int c = 1; c < yScale.length; ++c) {
                if (grid[r - 1][c - 1]) {
                    ans += scaleVal * (yScale[c] - yScale[c - 1]);
                }
                if (ans > Integer.MAX_VALUE)
                    ans %= 1000000007;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(rectangleArea(new int[][]{{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}}));
        System.out.println(rectangleArea(new int[][]{{0, 0, 1000000000, 1000000000}}));
    }

}
