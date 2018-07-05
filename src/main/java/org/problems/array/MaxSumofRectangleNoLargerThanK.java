package org.problems.array;

import java.util.TreeSet;

//https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
public class MaxSumofRectangleNoLargerThanK {

    public static int maxSumSubmatrix1(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; ++i) {
            int[] colmSum = new int[matrix[0].length];
            for (int j = i; j >= 0; --j) {
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int curSum = 0;
                for (int c = 0; c < matrix[0].length; ++c) {
                    colmSum[c] += matrix[j][c];
                    curSum += colmSum[c];
                    Integer savedSum = sumSet.ceiling(curSum - k);
                    if (savedSum != null)
                        res = Math.max(res, curSum - savedSum);
                    sumSet.add(curSum);
                }
            }
        }
        return res;
    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; ++i) {
            int[] rowSum = new int[matrix.length];
            for (int j = i; j >= 0; --j) {
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int curSum = 0;
                for (int r = 0; r < matrix.length; ++r) {
                    rowSum[r] += matrix[r][j];
                    curSum += rowSum[r];
                    Integer savedSum = sumSet.ceiling(curSum - k);
                    if (savedSum != null)
                        res = Math.max(res, curSum - savedSum);
                    sumSet.add(curSum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubmatrix(new int[][]{{2, 2, -1}}, 0) == -1);
        System.out.println(maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3) == 3);
        System.out.println(maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2) == 2);
    }
}
