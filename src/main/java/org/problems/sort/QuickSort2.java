package org.problems.sort;

import java.util.Arrays;

public class QuickSort2 {

    public static void sort(int arr[], int lo, int hi) {
        if (lo < hi) {
            int partition = partition(arr, lo, hi);
            sort(arr, lo, partition - 1);
            sort(arr, partition + 1, hi);
        }
    }

    private static int partition(int arr[], int lo, int hi) {
        int partition = lo;
        int pivot = arr[hi];
        for (int i = lo; i < hi; ++i) {
            if (arr[i] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[partition];
                arr[partition] = tmp;
                ++partition;
            }
        }
        int tmp = arr[hi];
        arr[hi] = arr[partition];
        arr[partition] = tmp;
        return partition;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 7, 3};
        sort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }
}
