package org.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/course-schedule-ii/description/
public class CourseSchedule2 {

    private static boolean dfs(List<Integer>[] g, int vertex, boolean[] visited, Deque<Integer> stack, boolean[] onStack) {
        visited[vertex] = true;
        onStack[vertex] = true;
        for (Integer v : g[vertex]) {
            if (!visited[v]) {
                boolean isCycle = dfs(g, v, visited, stack, onStack);
                if (isCycle)
                    return true;
            } else if (onStack[v])
                return true;
        }

        onStack[vertex] = false;
        stack.addFirst(vertex);
        return false;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];

        Deque<Integer> stack = new LinkedList<>();
        List<Integer>[] g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i)
            g[i] = new ArrayList<>(numCourses);

        for (int[] edge : prerequisites) {
            g[edge[0]].add(edge[1]);
        }

        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i]) {
                boolean isCycle = dfs(g, i, visited, stack, onStack);
                if (isCycle)
                    return new int[0];
            }
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = stack.pollLast();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}, {0, 1}})));
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{0, 1}})));
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
    }
}
