package org.problems.bits;

//https://leetcode.com/problems/power-of-four/description/
public class PowerofFour {
    public static boolean isPowerOfFour(int num) {
        if ((num & -num) != num)
            return false;
        int count = 0;
        while (num > 1) {
            num = num >> 1;
            count += 1;
        }
        return count % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
    }
}
