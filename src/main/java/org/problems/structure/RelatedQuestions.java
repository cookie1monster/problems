package org.problems.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/contests/quora-haqathon/challenges/relatedquestions
public class RelatedQuestions {

    private static void dfsPre(List<Integer>[] tree, int root, boolean[] visited, int[] time, double[] down) {
        visited[root] = true;
        int qnt = 0;
        for (int i : tree[root]) {
            if (!visited[i]) {
                dfsPre(tree, i, visited, time, down);
                down[root] += down[i];
                ++qnt;
            }
        }
        if (qnt == 0)
            down[root] += time[root];
        else
            down[root] = down[root] / qnt + time[root];
    }

    private static void dfsPost(List<Integer>[] tree, int root, boolean[] visited, int[] time, double[] down, double[] res, double parent) {
        visited[root] = true;
        int qnt = Math.max(1, tree[root].size() - 1);
        res[root] = ((down[root] - time[root]) * qnt + parent);

        for (int i : tree[root]) {
            if (!visited[i]) {
                double nextPerent = (res[root] - down[i]) / qnt + time[root];
                dfsPost(tree, i, visited, time, down, res, nextPerent);
            }
        }
        res[root] = res[root] / tree[root].size() + time[root];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] time = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; ++i) {
            time[i] = in.nextInt();
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; ++i) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        double[] down = new double[n + 1];
        double[] res = new double[n + 1];

        dfsPre(graph, 2, new boolean[n + 1], time, down);
        dfsPost(graph, 2, new boolean[n + 1], time, down, res, 0);
        double minTime = Double.MAX_VALUE;
        int index = 0;
        for (int i = 1; i <= n; ++i) {
            if (minTime > res[i]) {
                minTime = res[i];
                index = i;
            }
        }
        
        System.out.println(index);
    }

}
