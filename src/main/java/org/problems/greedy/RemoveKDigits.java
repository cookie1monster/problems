package org.problems.greedy;

//https://leetcode.com/problems/remove-k-digits/description/
public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        char[] stack = new char[num.length() + 1];
        int hi = 0;
        int lo = 0;

        for (int i = 0; i < num.length(); ++i) {
            while (hi - lo > 0 && stack[hi - 1] > num.charAt(i) && k-- > 0)
                --hi;
            stack[hi++] = num.charAt(i);
        }

        while (hi - lo > 0 && stack[lo] == '0')
            ++lo;

        while (hi - lo > 0 && k-- > 0)
            --hi;

        if (lo - hi == 0)
            return "0";

        return String.valueOf(stack).substring(lo, hi);
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3).equals("1219"));
        System.out.println(removeKdigits("1234567890", 9).equals("0"));
        System.out.println(removeKdigits("112", 1).equals("11"));
        System.out.println(removeKdigits("10200", 1).equals("200"));
        System.out.println(removeKdigits("10", 1).equals("0"));
        System.out.println(removeKdigits("9", 1).equals("0"));
    }
}
