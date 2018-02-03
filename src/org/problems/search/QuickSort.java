package org.problems.search;

public class QuickSort {

    static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start;
        for (int j=start; j<end; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }

    static void sort(int arr[], int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);
            sort(arr, start, partition-1);
            sort(arr, partition+1, end);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,6,4,5,7,3};
        sort(arr, 0, arr.length-1);
        for (int i=0; i<arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
