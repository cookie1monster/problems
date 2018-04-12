package org.problems.structure;

//https://leetcode.com/problems/search-a-2d-matrix/description/
public class Search2DMatrix {


    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        while (i < matrix.length && matrix[i].length > 0 && matrix[i][0] <= target) {
            ++i;
        }
        if (i > matrix.length || i == 0)
            return false;

        --i;
        for (int val : matrix[i]) {
            if (val == target)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] table = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(table, 10));
    }

}
