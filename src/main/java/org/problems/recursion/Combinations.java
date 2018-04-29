package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/description/
public class Combinations {

    public static void combine(int n, int k, List<Integer> list, List<List<Integer>> lists) {
        for (int i = n; i > 0; --i) {
            list.add(i);
            if (list.size() == k) {
                lists.add(new ArrayList<>(list));
            } else {
                combine(i - 1, k, list, lists);
            }
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        combine(n, k, new ArrayList<>(), lists);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(3, 3));
    }
}
