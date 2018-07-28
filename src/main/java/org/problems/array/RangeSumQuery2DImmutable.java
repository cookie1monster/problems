package org.problems.array;

//https://leetcode.com/problems/range-sum-query-2d-immutable/description/
public class RangeSumQuery2DImmutable {

    public static void main(String[] args) {

        NumMatrix matrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});
        System.out.println(matrix.sumRegion(1, 1, 2, 2) == 11);
        System.out.println(matrix.sumRegion(0, 0, 1, 1) == 14);

        System.out.println(matrix.sumRegion(2, 1, 4, 3) == 8);
        System.out.println(matrix.sumRegion(1, 2, 2, 4) == 12);
        System.out.println(matrix.sumRegion(0, 0, 0, 0) == 3);
        System.out.println(matrix.sumRegion(1, 1, 1, 1) == 6);
    }
}

class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length < 1)
            return;
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                sum[i + 1][j + 1] = matrix[i][j] - sum[i][j];
                sum[i + 1][j + 1] += sum[i][j + 1] + sum[i + 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum.length < 1)
            return 0;
        int res = sum[row2 + 1][col2 + 1] + sum[row1][col1];
        res = res - sum[row1][col2 + 1] - sum[row2 + 1][col1];
        return res;
    }
}