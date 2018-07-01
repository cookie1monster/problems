package org.problems.array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/lexicographical-numbers/description/
public class LexicographicalNumbers {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n + 1);
        list.add(1);
        int multN = n / 10;
        while (list.size() < n) {
            int val = list.get(list.size() - 1);
            while (val <= multN) {
                val *= 10;
                list.add(val);
            }
            if (val >= n)
                val /= 10;
            while (val % 10 == 9)
                val /= 10;
            list.add(val + 1);
        }
        return list;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 100;
        System.out.println(lexicalOrder(n));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
