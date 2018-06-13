package org.problems.dp;

import java.util.Arrays;

//https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/description/
public class NonTegativeIntegerswithoutConsecutiveOnes {

    private static int count(int[] bitNumber, int[] num, int last, int[] dp) {
        if (bitNumber.length < last)
            return 0;

        if (num[last] == 0 && dp[last] != -1 && last > 0 && bitNumber[last - 1] == 1)
            return dp[last];

        for (int i = 0; i < last; ++i) {
            if (bitNumber[i] > num[i + 1])
                break;
            else if (bitNumber[i] < num[i + 1])
                return 0;
        }

        if (bitNumber.length == last)
            return 1;

        int count = count(bitNumber, num, last + 1, dp);
        if (num[last] == 0) {
            num[last + 1] = 1;
            dp[last] = count + count(bitNumber, num, last + 1, dp);
            num[last + 1] = 0;
            count = dp[last];
        }
        return count;
    }

    public static int findIntegers(int num) {
        char[] bitNumberChar = Integer.toBinaryString(num).toCharArray();
        int[] bitNumber = new int[bitNumberChar.length];
        for (int i = 0; i < bitNumber.length; ++i) {
            bitNumber[i] = bitNumberChar[i] - '0';
        }
        int[] dp = new int[bitNumber.length + 1];
        Arrays.fill(dp, -1);
        return count(bitNumber, new int[bitNumber.length + 1], 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(findIntegers(4) == 4);
        System.out.println(findIntegers(20) == 12);
        System.out.println(findIntegers(98176353) == 514229);
        System.out.println(findIntegers(977466316) == 2178309);

    }
}
