package org.problems.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/sum-of-distances-in-tree/description/
public class SumofDistancesinTree {

    private static void dfsPre(List<Integer>[] tree, int root, boolean[] visited, int[] res, int[] count) {
        visited[root] = true;
        for (int i : tree[root]) {
            if (!visited[i]) {
                dfsPre(tree, i, visited, res, count);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
        }
        count[root]++;
    }

    private static void dfsPost(List<Integer>[] tree, int root, boolean[] visited, int[] res, int[] count, int N) {
        visited[root] = true;
        for (int i : tree[root]) {
            if (!visited[i]) {
                res[i] = res[root] - count[i] + N - count[i];
                dfsPost(tree, i, visited, res, count, N);
            }
        }
    }

    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        List<Integer>[] tree = new List[N];
        for (int i = 0; i < N; ++i)
            tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        int[] res = new int[N];
        int[] count = new int[N];
        dfsPre(tree, 0, new boolean[N], res, count);
        dfsPost(tree, 0, new boolean[N], res, count, N);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfDistancesInTree(4, new int[][]{{1, 2}, {3, 2}, {3, 0}})));
        System.out.println(Arrays.toString(sumOfDistancesInTree(4, new int[][]{{1, 2}, {2, 0}, {0, 3}})));
        System.out.println(Arrays.toString(sumOfDistancesInTree(3, new int[][]{{2, 0}, {1, 0}})));
        System.out.println(Arrays.toString(sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
    }

}
