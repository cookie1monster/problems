package org.problems.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/split-array-into-fibonacci-sequence/description/
public class SplitArrayintoFibonacciSequence {

    public static List<Integer> splitIntoFibonacci(String S) {
        for (int i = 1; i < Math.min(9, S.length()); ++i) {
            String firstStr = S.substring(0, i);
            if (firstStr.length() > 1 && firstStr.charAt(0) == '0')
                break;
            long first = Long.parseLong(firstStr);
            for (int j = i + 1; j < Math.min(i + 9, S.length()); ++j) {
                String secondStr = S.substring(i, j);
                if (secondStr.length() > 1 && secondStr.charAt(0) == '0')
                    break;
                long second = Long.parseLong(secondStr);
                if (S.substring(j).startsWith(String.valueOf(first + second))) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add((int) first);
                    ans.add((int) second);
                    if (splitIntoFibonacci(S.substring(j), second, first + second, ans) && ans.size() > 2)
                        return ans;
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    private static boolean splitIntoFibonacci(String s, long first, long second, List<Integer> ans) {
        if (Math.abs(second) > Integer.MAX_VALUE)
            return false;
        ans.add((int) second);
        int index = String.valueOf(second).length();
        if (s.substring(index).isEmpty())
            return true;
        if (s.substring(index).startsWith(String.valueOf(first + second)))
            return (splitIntoFibonacci(s.substring(index), second, first + second, ans));
        return false;
    }

    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("65155860565120123725188845312570501415813985131540021293853444785557417090189551459312523612080"));
        System.out.println(splitIntoFibonacci("0000"));
        System.out.println(splitIntoFibonacci("0123"));
        System.out.println(splitIntoFibonacci("1101111"));
        System.out.println(splitIntoFibonacci("123456579"));
    }
}
