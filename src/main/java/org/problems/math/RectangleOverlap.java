package org.problems.math;

//https://leetcode.com/contest/weekly-contest-85/problems/rectangle-overlap/
public class RectangleOverlap {

    public static boolean isRectangleOverlap(int[] r1, int[] r2) {
        return ((r1[2] > r2[0] && r2[2] > r1[0] || r1[0] == r2[0] || r1[2] == r2[2])
                && (r1[3] > r2[1] && r2[3] > r1[1] || r1[1] == r2[1] || r1[3] == r2[3]));
    }

    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
    }

}
