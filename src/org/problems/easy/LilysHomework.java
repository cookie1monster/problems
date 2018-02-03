package org.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/lilys-homework/problem
public class LilysHomework {

    static int partition(int[] arr, int start, int end) {
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

    static int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return arr;
    }

    static int findCost(int[] arr, int[] sortedArr, int costAprx) {
        Map<Integer, Integer> initialMap = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            initialMap.put(arr[i], i);
        }
        
        int cost = 0;
        for(int i=0; i<sortedArr.length; ++i) {
            if (arr[i] != sortedArr[i]) {
                int tempIndex = initialMap.get(sortedArr[i]);
                initialMap.put(arr[i], tempIndex);
                arr[tempIndex] = arr[i];
                cost++;
                if (cost > costAprx) {
                    return costAprx;
                }
            }
        }
        return cost;
    }

    static int lilysHomework(int[] arr) {
        int[] reverseArr = reverse(Arrays.copyOf(arr, arr.length));
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        //sort(sortedArr, 0, sortedArr.length-1);
        Arrays.sort(sortedArr, 0, sortedArr.length);
        int cost1 = findCost(reverseArr, sortedArr, sortedArr.length);
        int cost2 = findCost(arr, sortedArr, cost1);
        return Math.min(cost1, cost2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = lilysHomework(arr);
        System.out.println(result);
        in.close();
    }
}
