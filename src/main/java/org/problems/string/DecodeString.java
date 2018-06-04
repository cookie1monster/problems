package org.problems.string;

//https://leetcode.com/problems/decode-string/description/
public class DecodeString {

    private static String decodeString(String s, int n) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder number = new StringBuilder("0");
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                number.append(ch);
            } else if (ch == '[') {
                str.replace(i - number.length() + 1, str.length(),
                        decodeString(str.substring(i + 1), Integer.parseInt(number.toString())));
                number = new StringBuilder("0");
                --i;
            } else if (ch == ']') {
                str.replace(i, i + 1, "");
                for (int j = 0; j < n - 1; ++j)
                    str.insert(0, str.substring(0, i));
                return str.toString();
            }
            ++i;
        }
        return str.toString();
    }

    public static String decodeString(String s) {
        return decodeString(s, 1);
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("3[2[jk]e1[f]]"));
        System.out.println(decodeString("2[2[b]]"));
        System.out.println(decodeString("1[a]112[bc]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
    }
}
