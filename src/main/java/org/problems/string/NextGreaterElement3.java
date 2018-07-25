package org.problems.string;

import java.util.Arrays;

//https://leetcode.com/problems/next-greater-element-iii/description/
public class NextGreaterElement3 {

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        long res = 0;
        for (int i = arr.length - 1; i > 0; --i) {
            if (arr[i] > arr[i - 1]) {
                swap(arr, i, i - 1);
                char val = arr[i];
                char val1 = arr[i - 1];
                Arrays.sort(arr, i, arr.length);
                int j = i;
                while (j < arr.length && arr[j] < val1 && (arr[j] == val || arr[j] < val)) {
                    ++j;
                }
                if (j < arr.length)
                    swap(arr, j, i - 1);
                Arrays.sort(arr, i, arr.length);
                res = Long.parseLong(String.valueOf(arr));
                break;
            }
        }
        if (res != 0 && res <= Integer.MAX_VALUE)
            return (int) res;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(1200000) == 2000001);
        System.out.println(nextGreaterElement(12443322) == 13222344);
        System.out.println(nextGreaterElement(230241) == 230412);
    }
}
