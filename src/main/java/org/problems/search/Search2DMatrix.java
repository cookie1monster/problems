package org.problems.search;

//https://leetcode.com/problems/search-a-2d-matrix/description/
public class Search2DMatrix {

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

    private static int binarySearchVertical(int[][] arr, int lo, int hi, int val) {
        if (lo > hi)
            return -1;
        int index = lo - 1;
        int mid = (lo + hi) / 2;

        if (val == arr[mid][0])
            return mid;

        if (arr[lo][0] <= val && val < arr[mid][0]) {
            index = binarySearchVertical(arr, lo, mid - 1, val);
        } else if (arr[mid][0] < val && val <= arr[hi][0]) {
            index = binarySearchVertical(arr, mid + 1, hi, val);
        } else if (val > arr[hi][0])
            index = hi;
        return index;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target)
            return false;
        int index = binarySearchVertical(matrix, 0, matrix.length - 1, target);
        return binarySearch(matrix[index], 0, matrix[index].length - 1, target);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};

        System.out.println(searchMatrix(matrix, 51));
    }
}
