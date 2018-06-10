package org.problems.search;

//https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class Search2DMatrix2 {

    private static boolean binarySearch(int[] arr, int lo, int hi, int val) {
        if (lo > hi)
            return false;
        int mid = (lo + hi) / 2;

        if (arr[mid] == val)
            return true;

        if (arr[mid] > val)
            return binarySearch(arr, lo, mid - 1, val);
        else
            return binarySearch(arr, mid + 1, hi, val);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int n = matrix[0].length - 1;
        int i = 0;
        while (i < matrix.length && matrix[i][0] <= target) {
            if (matrix[i][n] >= target && binarySearch(matrix[i], 0, n, target))
                return true;
            ++i;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.println(searchMatrix(matrix, 25));
    }
}
