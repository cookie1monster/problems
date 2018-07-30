package org.problems.pointer;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/unique-letter-string/description/
public class UniqueLetterString {

    public static int uniqueLetterString1(String S) {
        char[] arr = S.toCharArray();
        long sum = 0;
        int[] freq = new int[28];
        for (int i = 0; i < arr.length; ++i) {
            long curSum = 0;

            int uniqueCount = 0;
            for (int j = i; j < arr.length; ++j) {
                if (freq[arr[j] - 'A'] == 0) {
                    ++uniqueCount;
                    ++freq[arr[j] - 'A'];
                } else if (freq[arr[j] - 'A'] == 1) {
                    --uniqueCount;
                    ++freq[arr[j] - 'A'];

                }
                curSum += uniqueCount;
            }
            sum += curSum;
        }
        return (int) (sum % 1000000007);
    }

    public static int uniqueLetterString(String S) {
        long sum = 0;
        char[] arr = S.toCharArray();
        List<Integer>[] boundariesArr = new List[28];
        for (int i = 0; i < arr.length; ++i) {
            if (boundariesArr[arr[i] - 'A'] == null)
                boundariesArr[arr[i] - 'A'] = new ArrayList<>();
            boundariesArr[arr[i] - 'A'].add(i);
        }

        for (List<Integer> boundaries : boundariesArr) {
            if (boundaries == null) continue;
            for (int i = 0; i < boundaries.size(); ++i) {
                long prev = i > 0 ? boundaries.get(i - 1) : -1;
                long next = i < boundaries.size() - 1 ? boundaries.get(i + 1) : arr.length;
                sum += (boundaries.get(i) - prev) * (next - boundaries.get(i));
            }
        }
        return (int) (sum % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("BABABBABAA") == 35);
        System.out.println(uniqueLetterString("AAA") == 3);
        System.out.println(uniqueLetterString("ABA") == 8);
        System.out.println(uniqueLetterString("ABC") == 10);
    }
}
