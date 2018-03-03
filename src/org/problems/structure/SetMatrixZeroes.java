package org.problems.structure;

//https://leetcode.com/problems/set-matrix-zeroes/description/
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        boolean row = false;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                row = true;
                break;
            }
        }
        boolean column = false;
        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                column = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }
        if (column) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] table = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 }, { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
        setZeroes(table);
        System.out.println(table);
    }

}
