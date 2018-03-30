package org.problems.easy;

//https://leetcode.com/problems/rotate-image/description/
public class RotateImage {

    public static void rotate(int[][] matrix) {
        for (int level = 0; level < matrix.length / 2; ++level) {
            for (int i = level; i < matrix.length - level - 1; ++i) {
                int temp = matrix[level][i];
                matrix[level][i] = matrix[matrix.length - i - 1][level];
                matrix[matrix.length - i - 1][level] = matrix[matrix.length - level - 1][matrix.length - i - 1];
                matrix[matrix.length - level - 1][matrix.length - i - 1] = matrix[i][matrix.length - level - 1];
                matrix[i][matrix.length - level - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {
                        5, 1, 9, 11
                },
                {
                        2, 4, 8, 10
                },
                {
                        13, 3, 6, 7
                },
                {
                        15, 14, 12, 16
                }
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
