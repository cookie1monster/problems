package org.problems.sort;

import java.util.Arrays;

public class MergeSort2 {

    public static void sort(int arr[], int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);

        merge(arr, lo, hi);
    }

    public static void merge(int arr[], int lo, int hi) {
        int mid = (lo + hi) / 2;
        int[] tmp = new int[hi - lo + 1];

        int index1 = lo;
        int index2 = mid + 1;
        int index = 0;

        while (index1 <= mid && index2 <= hi)
            tmp[index++] = (arr[index1] < arr[index2]) ? arr[index1++] : arr[index2++];

        while (index1 <= mid)
            tmp[index++] = arr[index1++];

        while (index2 <= hi)
            tmp[index++] = arr[index2++];

        for (int i = lo; i <= hi; ++i)
            arr[i] = tmp[i - lo];
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 7, 3};
        sort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }
}