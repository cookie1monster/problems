package org.problems.math;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/contests/quora-haqathon/challenges/schedule/problem
public class Schedule {

    public static double minimumExpectedTime(double[][] tests) {
        int n = tests.length;
        Arrays.sort(tests, (x, y) -> {
            if ((1 - x[1]) / x[0] > (1 - y[1]) / y[0])
                return -1;
            return 1;
        });
        double p = 1.;
        double res = tests[0][0];
        for (int i = 1; i < n; ++i) {
            p *= tests[i - 1][1];
            res += tests[i][0] * p;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[][] tests = new double[n][2];
        for (int i = 0; i < n; ++i) {
            tests[i][0] = in.nextInt();
            tests[i][1] = in.nextDouble();
        }
        System.out.println(minimumExpectedTime(tests));
    }
}
