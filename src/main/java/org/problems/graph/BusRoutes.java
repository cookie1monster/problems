package org.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/bus-routes/description/
public class BusRoutes {

    private static int bfs(List<List<Integer>> routeGraph, Set<Integer> onTrack, boolean[] visited, int dist, Set<Integer> end) {
        if (onTrack.isEmpty())
            return Integer.MAX_VALUE;
        Set<Integer> nextOnTrack = new HashSet<>();

        for (int route : onTrack) {
            if (visited[route]) continue;
            if (end.contains(route)) return dist;
            visited[route] = true;
            nextOnTrack.addAll(routeGraph.get(route));
        }

        return bfs(routeGraph, nextOnTrack, visited, dist + 1, end);
    }

    public static boolean isIntersect(int[] a, int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) return true;
            if (a[i] < b[j]) i++;
            else j++;
        }
        return false;
    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        List<List<Integer>> routeGraph = new ArrayList<>();
        for (int[] route : routes) {
            Arrays.sort(route);
            routeGraph.add(new ArrayList<>());
        }

        Set<Integer> start = new HashSet<>();
        Set<Integer> end = new HashSet<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int stop : routes[i]) {
                if (stop == S) start.add(i);
                if (stop == T) end.add(i);
            }
            for (int j = i + 1; j < routes.length; ++j) {
                if (isIntersect(routes[i], routes[j])) {
                    routeGraph.get(i).add(j);
                    routeGraph.get(j).add(i);
                }
            }
        }

        int dist = bfs(routeGraph, start, new boolean[501], 1, end);
        return (dist == Integer.MAX_VALUE) ? -1 : dist;
    }

    public static void main(String[] args) {
        System.out.println(numBusesToDestination(new int[][]{{1, 9, 7}, {3, 6, 7}}, 1, 3));
    }
}
