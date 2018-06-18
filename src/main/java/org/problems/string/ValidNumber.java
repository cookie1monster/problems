package org.problems.string;

//https://leetcode.com/problems/valid-number/description/
public class ValidNumber {

    private static boolean isNumber(String s) {
        s = s.toLowerCase();
        if (s.contains("d") || s.contains("f"))
            return false;
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException exp) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("959440.94d"));
    }
}
