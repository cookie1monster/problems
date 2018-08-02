package org.problems.recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StringPermutation {

    private static void stringPermutation(String str, String left, List<String> res) {
        if (left.length() == 0)
            res.add(str);
        for (int i = 0; i < left.length(); ++i) {
            stringPermutation(str + left.charAt(i), left.substring(0, i) + left.substring(i + 1), res);
        }
    }

    public static List<String> stringPermutation1(String str) {
        List<String> res = new ArrayList<>();
        stringPermutation("", str, res);
        return res;
    }

    public static List<String> stringPermutation(String str) {
        List<String> res = new ArrayList<>();

        Deque<String[]> que = new LinkedList<>();
        que.addLast(new String[]{"", str});

        while (!que.isEmpty()) {
            String[] perm = que.pollFirst();
            if (perm[1].length() == 0)
                res.add(perm[0]);
            else {
                for (int i = 0; i < perm[1].length(); ++i) {
                    que.addLast(new String[]{perm[0] + perm[1].charAt(i), perm[1].substring(0, i) + perm[1].substring(i + 1)});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(stringPermutation("1234"));
    }
}
