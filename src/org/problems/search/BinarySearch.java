package org.problems.search;

import java.util.Scanner;

public class BinarySearch {

    static int binarySearch(int[] arr, int val, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (arr[mid] == val) {
            return mid;
        } else if (arr[mid] < val) {
            return binarySearch(arr, val, mid + 1, hi);
        } else {
            return binarySearch(arr, val, lo, mid - 1);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[]{4, 6, 9, 13, 14, 15, 16};
        System.out.println(binarySearch(arr, sc.nextInt(), 0, arr.length - 1));
    }
}
