package org.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/all-paths-from-source-to-target/description/
public class AllPathsFromSourcetoTarget {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph.length < 1)
            return new ArrayList<>();

        int target = graph.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        Deque<List<Integer>> que = new LinkedList<>();
        for (int i = 0; i < graph[0].length; ++i)
            que.addLast(Arrays.asList(0, graph[0][i]));

        while (!que.isEmpty()) {
            List<Integer> path = que.pollFirst();
            int v = path.get(path.size() - 1);
            if (v == target)
                res.add(path);
            else {
                for (int i = 0; i < graph[v].length; ++i) {
                    List<Integer> nextPath = new ArrayList<>(path);
                    nextPath.add(graph[v][i]);
                    if (graph[v][i] == target)
                        res.add(nextPath);
                    else
                        que.addLast(nextPath);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }
}
