package org.problems.array;

//https://leetcode.com/problems/spiral-matrix-iii/description/
public class SpiralMatrix3 {

    public static int[][] spiralMatrixIII(int R, int C, int r, int c) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int[][] ans = new int[R * C][2];

        int i = 0;
        ans[i][0] = r;
        ans[i++][1] = c;
        if (R * C == 1) return ans;

        for (int k = 1; k < 2 * (R + C); k += 2) {
            for (int d = 0; d < 4; ++d) {
                int dk = k + (d / 2);
                for (int j = 0; j < dk; ++j) {
                    r += dr[d];
                    c += dc[d];
                    if (0 <= r && r < R && 0 <= c && c < C) {
                        ans[i][0] = r;
                        ans[i++][1] = c;
                        if (i == R * C) return ans;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(spiralMatrixIII(1, 4, 0, 0));
    }
}
