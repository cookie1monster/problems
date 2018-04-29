package org.problems.easy;

//https://leetcode.com/problems/excel-sheet-column-title/description/
public class ConvertToTitle {

    private static final int CHAR_OFFSET = 64;
    public static String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            int number = n % 26;
            if (number == 0) number = 26;
            result = (char)(number + CHAR_OFFSET) + result;
            n = (n - number) / 26;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(2));
    }
}
