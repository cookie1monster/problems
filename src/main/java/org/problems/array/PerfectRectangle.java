package org.problems.array;

import java.util.NavigableSet;
import java.util.TreeSet;

//https://leetcode.com/problems/perfect-rectangle/description/
public class PerfectRectangle {

    static class Rect {
        int[] r1;

        public Rect(int[] rect) {
            this.r1 = rect;
        }

        @Override
        public int hashCode() {
            return 17;
        }

        @Override
        public boolean equals(Object r) {
            int[] r2 = ((Rect) r).r1;
            return ((r1[2] > r2[0] && r2[2] > r1[0] || r1[0] == r2[0] || r1[2] == r2[2])
                    && (r1[3] > r2[1] && r2[3] > r1[1] || r1[1] == r2[1] || r1[3] == r2[3]));
        }
    }

    public static boolean isRectangleCover(int[][] rectangles) {

        int squareSum = 0;
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;

        NavigableSet<int[]> rectSet = new TreeSet<>((r1, r2) -> {
            if ((r1[2] > r2[0] && r2[2] > r1[0] || r1[0] == r2[0] || r1[2] == r2[2])
                    && (r1[3] > r2[1] && r2[3] > r1[1] || r1[1] == r2[1] || r1[3] == r2[3]))
                return 0;
            int lo = (r1[0] * r1[1] - r2[0] * r2[1]);
            if (lo != 0)
                return lo;
            int hi = (r1[2] * r1[3] - r2[2] * r2[3]);
            if (hi != 0)
                return hi;

            int j = 0;
            while (j < 4 && r1[j] == r2[j])
                ++j;
            return r1[j] - r2[j];
        });

        for (int j = 0; j < rectangles.length; ++j) {

            xMin = Math.min(xMin, rectangles[j][0]);
            yMin = Math.min(yMin, rectangles[j][1]);

            xMax = Math.max(xMax, rectangles[j][2]);
            yMax = Math.max(yMax, rectangles[j][3]);

            int oldSize = rectSet.size();
            rectSet.add(rectangles[j]);
            if (oldSize == rectSet.size())
                return false;

            squareSum += (rectangles[j][2] - rectangles[j][0]) * (rectangles[j][3] - rectangles[j][1]);
        }

        return rectSet.size() == rectangles.length
                && squareSum == ((xMax - xMin) * (yMax - yMin));
    }

    public static void main(String[] args) {
        //true
        System.out.println(isRectangleCover(new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        }));

        //false
        System.out.println(isRectangleCover(new int[][]{{0, 0, 2, 1}, {0, 1, 2, 2}, {0, 2, 1, 3}, {1, 0, 2, 1}}));

        //false
        System.out.println(isRectangleCover(new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {1, 3, 2, 4},
                {2, 2, 4, 4}
        }));
    }
}
