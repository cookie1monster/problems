package org.problems.sort;

import java.util.Arrays;

public class QuickSort3 {

    public static void sort(int arr[], int lo, int hi) {
        if (lo < hi) {
            int partition = partition(arr, lo, hi);
            sort(arr, lo, partition - 1);
            sort(arr, partition + 1, hi);
        }
    }

    private static int partition(int arr[], int lo, int hi) {
        int partition = hi;
        while (lo < partition) {
            if (arr[lo] > arr[hi]) {
                --partition;
                int tmp = arr[lo];
                arr[lo] = arr[partition];
                arr[partition] = tmp;
            } else
                ++lo;
        }
        int tmp = arr[hi];
        arr[hi] = arr[partition];
        arr[partition] = tmp;

        return partition;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 6, 4, 5, 7, 3};
        int[] arr = {3,2,1,4};
        sort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }
}
