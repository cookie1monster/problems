package org.problems.math;

//https://leetcode.com/contest/weekly-contest-83/problems/consecutive-numbers-sum/
public class ConsecutiveNumbersSum {

    public static int consecutiveNumbersSum(int N) {
        int result = 1;
        for (int l = 1; l * (l + 1) < 2 * N; ++l) {
            double a = ((1.0 * N - (l * (l + 1)) / 2) / (l + 1));
            if (a - (int) a == 0.0)
                ++result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(5) == 2);
        System.out.println(consecutiveNumbersSum(9) == 3);
        System.out.println(consecutiveNumbersSum(15) == 4);
    }
}
