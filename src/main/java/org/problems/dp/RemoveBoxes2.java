package org.problems.dp;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/remove-boxes/description/
public class RemoveBoxes2 {

    static class Boxes {
        int box;
        int qnt;

        Boxes(int box, int qnt) {
            this.box = box;
            this.qnt = qnt;
        }
    }

    private static int removeBoxesSub(List<Boxes> boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];

        k += boxes.get(i).qnt;
        int res = k * k + removeBoxesSub(boxes, i + 1, j, 0, dp);

        for (int m = i + 1; m <= j; m++) {
            if (boxes.get(i).box == boxes.get(m).box) {
                res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k, dp));
            }
        }

        dp[i][j][k - boxes.get(i).qnt] = res;
        return res;
    }

    public static int removeBoxes(int[] boxes) {
        List<Boxes> boxesList = new ArrayList<>();
        for (int val : boxes) {
            if (boxesList.size() > 0 && boxesList.get(boxesList.size() - 1).box == val)
                boxesList.get(boxesList.size() - 1).qnt++;
            else
                boxesList.add(new Boxes(val, 1));
        }
        int n = boxesList.size();
        int[][][] dp = new int[n][n][boxes.length + 1];
        return removeBoxesSub(boxesList, 0, n - 1, 0, dp);
    }

    public static void main(String[] args) {

        System.out.println(removeBoxes(new int[]{1, 1, 1}) == 9);
        System.out.println(removeBoxes(new int[]{3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7}) == 136);
        System.out.println(removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}) == 23);
    }
}
