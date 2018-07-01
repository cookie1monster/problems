package org.problems.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/course-schedule/description/
//Topological Sorting
public class CourseSchedule {

    private static boolean dfs(List<Integer>[] g, int vertex, boolean[] visited, boolean[] onStack) {
        visited[vertex] = true;
        onStack[vertex] = true;
        for (int v : g[vertex]) {
            if (!visited[v]) {
                if (dfs(g, v, visited, onStack))
                    return true;
            } else if (onStack[v])
                return true;
        }
        onStack[vertex] = false;
        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; ++i)
            g[i] = new ArrayList<>();

        for (int[] edge : prerequisites)
            g[edge[0]].add(edge[1]);

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i] && dfs(g, i, visited, new boolean[numCourses]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(2, new int[][]{{0, 1}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
    }
}
