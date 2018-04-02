package org.problems.bits;

//https://leetcode.com/problems/sum-of-two-integers/description/
public class SumofTwoIntegers {

    public static int getSum(int a, int b) {
        return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(6 == getSum(2, 4));
        System.out.println(5 == getSum(3, 2));
    }
}
