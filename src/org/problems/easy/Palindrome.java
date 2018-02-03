package org.problems.easy;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/richie-rich/problem
public class Palindrome {

    static void increasePolindrome(char[] arr, boolean[] isChangedArr, int k) {
        int i = 0;
        while (k > 0 && i < arr.length/2) {
            if (arr[i] != '9') {
                if (k > 1 && !isChangedArr[i]) {
                    k-=2;
                    arr[i] = '9';
                    arr[arr.length-1-i] = '9';
                } else if (isChangedArr[i]) {
                    --k;
                    arr[i] = '9';
                    arr[arr.length-1-i] = '9';
                }
            }
            ++i;
        }
        if (k > 0 && arr[arr.length/2] != '9') {
            arr[arr.length/2] = '9';
        }
    }

    static String richieRich(String s, int n, int k) {
        char[] arr = s.toCharArray();
        boolean[] isChangedArr = new boolean[arr.length/2];
        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i] < arr[arr.length-1-i]) {
                --k;
                arr[i] = arr[arr.length-1-i];
                isChangedArr[i] = true;
            } else if (arr[i] > arr[arr.length-1-i]) {
                --k;
                arr[arr.length-1-i] = arr[i];
                isChangedArr[i] = true;
            }
        }

        if (k<0) {
            return String.valueOf("-1");
        }
        increasePolindrome(arr, isChangedArr, k);
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
    }

}
