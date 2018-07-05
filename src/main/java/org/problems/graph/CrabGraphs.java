package org.problems.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerrank.com/challenges/crab-graphs/problem


// NOT SOLVED
public class CrabGraphs {

    private static void crabGraphs(Map<Integer, List<Integer>> graph, Map<Integer, List<Integer>> crabs, int t, Set<Integer> avalible, int[] max, int start, int n) {
        if (max[0] == graph.keySet().size()) {
            return;
        }
        max[0] = Math.max(max[0], graph.keySet().size() - avalible.size());

        for (int i = start; i <= n; ++i) {
            if (avalible.contains(i) && crabs.get(i).isEmpty()) {
                for (int adj : graph.get(i)) {
                    if (avalible.contains(adj) && crabs.get(adj).size() < t) {
                        crabs.get(adj).add(i);
                        avalible.remove(i);
                        crabGraphs(graph, crabs, t, avalible, max, 1, n);
                        avalible.add(i);
                        crabs.get(adj).remove(crabs.get(adj).size() - 1);
                    }
                }
            }
        }
    }

    public static int crabGraphs(int n, int t, int[][] graph) {

        Map<Integer, List<Integer>> g = new HashMap<>();
        Map<Integer, List<Integer>> crabs = new HashMap<>();
        Set<Integer> avalible = new HashSet<>();
        for (int i = 1; i <= n; ++i) {
            avalible.add(i);
            g.put(i, new ArrayList<>(n));
            crabs.put(i, new ArrayList<>(n));
        }
        for (int i = 0; i < graph.length; ++i) {
            g.get(graph[i][0]).add(graph[i][1]);
            g.get(graph[i][1]).add(graph[i][0]);
        }

        int[] max = new int[]{0};
        crabGraphs(g, crabs, t, avalible, max, 1, n);
        return max[0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        int c = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//        for (int cItr = 0; cItr < c; cItr++) {
//            String[] ntm = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//            int n = Integer.parseInt(ntm[0]);
//
//            int t = Integer.parseInt(ntm[1]);
//
//            int m = Integer.parseInt(ntm[2]);
//
//            int[][] graph = new int[m][2];
//
//            for (int graphRowItr = 0; graphRowItr < m; graphRowItr++) {
//                String[] graphRowItems = scanner.nextLine().split(" ");
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//                for (int graphColumnItr = 0; graphColumnItr < 2; graphColumnItr++) {
//                    int graphItem = Integer.parseInt(graphRowItems[graphColumnItr]);
//                    graph[graphRowItr][graphColumnItr] = graphItem;
//                }
//            }
//
//            int result = crabGraphs(n, t, graph);
//            System.out.println(result);
//
//        }
//
//
//        scanner.close();

        int result = crabGraphs(8, 2, new int[][]{
                {1, 4},
                {2, 4},
                {3, 4},
                {5, 4},
                {5, 8},
                {5, 7},
                {5, 6}}
        );
        System.out.println(result);
    }
}
