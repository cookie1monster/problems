package org.problems.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/minimum-height-trees/description/
public class MinimumHeightTrees {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length < 1)
            return Collections.singletonList(0);

        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            g.add(new HashSet<>());

        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);

        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g.get(i).size() == 1)
                leaves.add(i);
        }
        int k = n;
        while (k > 2) {
            k -= leaves.size();
            List<Integer> nextLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = g.get(i).iterator().next();
                g.get(j).remove(i);
                if (g.get(j).size() == 1) nextLeaves.add(j);
            }
            leaves = nextLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(1, new int[][]{}));
        System.out.println(findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
        System.out.println(findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
    }
}
