package org.problems.math;

//https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
public class ConvertNumberHexadecimal {

    public static String toHex(int num) {
        if (num == 0)
            return "0";
        int shift = 4;
        int mask = (1 << shift) - 1;
        StringBuilder hex = new StringBuilder();
        while (num != 0) {
            int digit = num & mask;
            if (digit > 9)
                hex.append((char) ('a' + digit - 10));
            else
                hex.append(digit);
            num >>>= shift;
        }
        return hex.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(-7));
        System.out.println(Integer.toHexString(-7));
        System.out.println(Integer.toHexString(Integer.MAX_VALUE));
        System.out.println(toHex(Integer.MAX_VALUE));
        System.out.println(Integer.toHexString(Integer.MIN_VALUE));
        System.out.println(toHex(Integer.MIN_VALUE));
        System.out.println(toHex(26));
    }
}
