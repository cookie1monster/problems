package org.problems.easy;

//https://leetcode.com/problems/excel-sheet-column-title/description/
public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        for (int k = 0; k < matrix.length; ++k) {
            int i = k;
            int val = matrix[i][0];
            for (int j = 0; j < matrix[0].length && i < matrix.length; ++j, ++i) {
                if (matrix[i][j] != val)
                    return false;
            }
        }

        for (int k = 0; k < matrix[0].length; ++k) {
            int i = k;
            int val = matrix[0][i];
            for (int j = 0; j < matrix.length && i < matrix[0].length; ++j, ++i) {
                if (matrix[j][i] != val)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
    }
}
