package org.problems.bits;

//https://leetcode.com/problems/power-of-two/description/
public class PowerofTwo {

    public static boolean isPowerOfTwo1(int n) {
        if (n < 0) return false;
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count == 1;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        //return (n & (n-1)) == 0;
        return (n & (-n)) == n;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(11));

        int n = 8;
        System.out.println(Integer.toBinaryString(n & (-n)));
        System.out.println((n & (-n)) == 0);
        System.out.println(Integer.toBinaryString(n & (n - 1)));
        System.out.println(n & (n - 1));
    }
}
