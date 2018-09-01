package org.problems.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CombinationGenerator {

    public static List<List<Integer>> generateAllCombination1(int m, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        generateAllCombination(m, n, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void generateAllCombination(int m, int n, int start, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == m) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (start + m - list.size() > n)
            return;

        for (int i = start; i < n; ++i) {
            list.add(i);
            generateAllCombination(m, n, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }


    public static List<List<Integer>> generateAllCombination(int m, int n) {
        Queue<List<Integer>> que = new LinkedList<>();
        for (int i = 0; i < n; ++i)
            que.offer(Arrays.asList(i));
        while (que.peek().size() < m) {
            List<Integer> list = que.poll();
            for (int i = list.get(list.size() - 1) + 1; i < n; ++i) {
                List<Integer> nextList = new ArrayList<>(list);
                nextList.add(i);
                que.offer(nextList);
            }
        }
        return new ArrayList<>(que);
    }

    public static void main(String[] args) {
        System.out.println(generateAllCombination(3, 5));
    }
}
