package org.problems.dp;

//https://leetcode.com/problems/integer-break/description/
public class IntegerBreak {

    public static int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        if (n % 3 == 1)
            return (int)Math.pow(3, n / 3 - 1) * 4;
        if (n % 3 == 2)
            return (int)Math.pow(3, n / 3) * 2;
        return (int)Math.pow(3, n / 3);
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));

    }
}
