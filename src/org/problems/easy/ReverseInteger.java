package org.problems.easy;

//https://leetcode.com/problems/reverse-integer/description/
public class ReverseInteger {

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result * 10 / 10 != result) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(987));
        System.out.println(reverse(-123));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
    }
}
