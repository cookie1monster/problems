package org.problems.string;

//https://leetcode.com/contest/weekly-contest-83/problems/masking-personal-information/
public class MaskingPersonalInformation {

    public static String maskPII(String S) {
        String str = S.toLowerCase();
        if (S.indexOf('@') != -1) {
            int etc = S.indexOf('@');
            str = str.substring(0, 1) + "*****" + str.substring(etc - 1);
        } else {
            String tmp = str.replaceAll("[^\\d.]", "");
            if (tmp.length() == 10)
                str = "***-***-" + tmp.substring(tmp.length() - 4);
            else if (tmp.length() == 11)
                str = "+*-***-***-" + tmp.substring(tmp.length() - 4);
            else if (tmp.length() == 12)
                str = "+**-***-***-" + tmp.substring(tmp.length() - 4);
            else if (tmp.length() == 13)
                str = "+***-***-***-" + tmp.substring(tmp.length() - 4);
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(maskPII("LeetCode@LeetCode.com"));
        System.out.println(maskPII("AB@qq.com"));
        System.out.println(maskPII("1(234)567-890"));
        System.out.println(maskPII("86-(10)12345678"));
    }
}
