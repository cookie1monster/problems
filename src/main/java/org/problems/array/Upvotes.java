package org.problems.array;

import java.util.Scanner;

//https://www.hackerrank.com/contests/quora-haqathon/challenges/upvotes
public class Upvotes {

    public static void upvotes(int k, long[] arr) {
        int n = arr.length;
        long[][] inc = new long[2][n];
        long[][] dec = new long[2][n];

        inc[0][0] = 1;
        dec[0][0] = 1;
        for (int i = 1; i < n; ++i) {
            inc[0][i] = 1 + (arr[i] >= arr[i - 1] ? inc[0][i - 1] : 0);
            dec[0][i] = 1 + (arr[i] <= arr[i - 1] ? dec[0][i - 1] : 0);
        }

        inc[1][n - 1] = 1;
        dec[1][n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            inc[1][i] = 1 + (arr[i] >= arr[i + 1] ? inc[1][i + 1] : 0);
            dec[1][i] = 1 + (arr[i] <= arr[i + 1] ? dec[1][i + 1] : 0);
        }

        long ninc = 0;
        long ndec = 0;
        for (int i = 0; i < k - 1; ++i) {
            ninc += inc[0][i];
            ndec += dec[0][i];
        }

        for (int i = k - 1; i < n; ++i) {
            ninc += Math.min(k, inc[0][i]);
            ndec += Math.min(k, dec[0][i]);

            System.out.println(ninc - ndec);
            ninc -= Math.min(k, dec[1][i - (k - 1)]);
            ndec -= Math.min(k, inc[1][i - (k - 1)]);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; ++i)
            arr[i] = in.nextInt();

        upvotes(k, arr);
    }
}

//6 1 3 3 9 6 4 1
//5 2 7 10 9 9 10