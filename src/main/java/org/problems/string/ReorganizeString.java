package org.problems.string;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/reorganize-string/description/
public class ReorganizeString {

    public static Integer[] argsort(final int[] arr, final boolean ascending) {
        Integer[] indexes = new Integer[arr.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, new Comparator<Integer>() {
            @Override
            public int compare(final Integer i1, final Integer i2) {
                return (ascending ? 1 : -1) * Integer.compare(arr[i1], arr[i2]);
            }
        });
        return indexes;
    }

    public static String reorganizeString(String S) {
        if (S == null || S.length() == 0)
            return "";
        char[] arr = S.toCharArray();

        int[] freq = new int[26];
        for (int i = 0; i < arr.length; ++i) {
            freq[arr[i] - 'a']++;
        }

        Integer[] argArr = argsort(freq, false);

        if (freq[argArr[0]] > (arr.length - 1) / 2 + 1)
            return "";

        int start = 0;
        for (int i = 0; i < argArr.length; ++i) {
            for (int j = 0; j < freq[argArr[i]]; ++j) {
                arr[start + j] = (char) (argArr[i] + 'a');
            }
            start += freq[argArr[i]];
        }

        char[] result = new char[S.length()];
        int j = 0;
        for (int i = 0; i < arr.length / 2; ++i) {
            result[j++] = arr[i];
            result[j++] = arr[i + (arr.length - 1) / 2 + 1];
        }
        if (S.length() % 2 == 1)
            result[j] = arr[arr.length / 2];
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("aaabb"));
        System.out.println(reorganizeString("aab"));
    }
}
