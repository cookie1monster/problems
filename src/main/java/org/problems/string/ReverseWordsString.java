package org.problems.string;

//https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordsString {

    public static String reverseWords(String s) {
        char[] arr = s.replaceAll("\\s+", " ").trim().toCharArray();
        reverce(arr, 0, arr.length);
        int start = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] == ' ') {
                reverce(arr, start, i);
                start = i + 1;
            }
        }
        reverce(arr, start, arr.length);
        return new String(arr);
    }

    private static void reverce(char[] arr, int lo, int hi) {
        hi = lo + hi;
        for (int i = lo; i < hi / 2; ++i) {
            char tmp = arr[i];
            arr[i] = arr[hi - 1 - i];
            arr[hi - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  the skys    is blue  "));
        System.out.println(reverseWords("blue"));
    }
}

//3 4 5 6 7 8