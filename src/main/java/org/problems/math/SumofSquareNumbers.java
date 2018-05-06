package org.problems.math;

//https://leetcode.com/problems/sum-of-square-numbers/description/
public class SumofSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); ++i) {
            double b = Math.sqrt(c - i * i);
            if (b - (int) b == 0.0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(0) == true);
        System.out.println(judgeSquareSum(4) == true);
        System.out.println(judgeSquareSum(5) == true);
        System.out.println(judgeSquareSum(8) == true);
        System.out.println(judgeSquareSum(9) == true);
        System.out.println(judgeSquareSum(11) == false);
    }
}
