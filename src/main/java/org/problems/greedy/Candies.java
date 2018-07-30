package org.problems.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//https://leetcode.com/problems/candy/description/
//https://www.hackerrank.com/challenges/candies/problem
public class Candies {

    static long candies(int n, int[] arr) {
        int[] candies = new int[arr.length + 1];
        Arrays.fill(candies, 1);
        for (int i = arr.length - 2; i >= 0; --i)
            if (arr[i] > arr[i + 1])
                candies[i] = candies[i + 1] + 1;

        long sum = candies[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] < arr[i])
                candies[i] = Math.max(candies[i - 1] + 1, candies[i]);

            sum += candies[i];
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);
        System.out.println(result);
        scanner.close();
    }
}
