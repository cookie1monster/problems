package org.preparation;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
public class DFSconnectedCell {

    static int dfs(int[][] matrix, int i, int j) {
        if (i>=0 && i<matrix.length && j>=0 && j<matrix[0].length && matrix[i][j] == 1) {
            matrix[i][j] = 2;
            return 1 + dfs(matrix, i - 1, j - 1)
                    + dfs(matrix, i - 1, j)
                    + dfs(matrix, i - 1, j + 1)
                    + dfs(matrix, i, j - 1)
                    + dfs(matrix, i, j + 1)
                    + dfs(matrix, i + 1, j - 1)
                    + dfs(matrix, i + 1, j)
                    + dfs(matrix, i + 1, j + 1);
        }
        return 0;
    }

    static int connectedCell(int[][] matrix) {
        int tempQnt, qnt = 0;
        for(int i=0;i<matrix.length;++i) {
            for(int j=0;j<matrix[0].length;++j) {
                if (matrix[i][j] == 1) {
                    tempQnt = dfs(matrix, i, j);
                    if (tempQnt > qnt) {
                        qnt = tempQnt;
                    }
                }
            }
        }
        return qnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for(int matrix_i = 0; matrix_i < n; matrix_i++){
            for(int matrix_j = 0; matrix_j < m; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        int result = connectedCell(matrix);
        System.out.println(result);
        in.close();
    }
}
