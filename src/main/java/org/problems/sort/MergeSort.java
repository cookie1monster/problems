package org.problems.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int arr[], int start, int end) {
        int[] newArr = new int[end - start + 1];
        int mid = (start + end) / 2 + 1;
        int i = start;
        int j = mid;
        int index = 0;
        while (index <= end - start) {
            if (i < mid && j <= end)
                newArr[index++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
            else if (i < mid)
                newArr[index++] = arr[i++];
            else if (j <= end)
                newArr[index++] = arr[j++];
        }
        return newArr;
    }

    public static void sort(int arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            int[] merged = merge(arr, start, end);
            for (int i = start; i <= end; ++i)
                arr[i] = merged[i - start];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 7, 3};
        sort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }
}