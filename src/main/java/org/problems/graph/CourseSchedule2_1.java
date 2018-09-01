package org.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule-ii/description/
//Topological Sorting
public class CourseSchedule2_1 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];

        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; ++i)
            g[i] = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; ++i)
            g[prerequisites[i][0]].add(prerequisites[i][1]);


        Queue<Integer> schedule = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i]) continue;
            if (dfs(g, i, visited, onStack, schedule))
                return new int[]{};
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; ++i)
            ans[i] = schedule.poll();
        return ans;
    }

    private static boolean dfs(List<Integer>[] g, int start,
                                       boolean[] visited, boolean[] onStack, Queue<Integer> schedule) {
        visited[start] = true;
        onStack[start] = true;

        for (int vertex : g[start]) {
            if (visited[vertex]) {
                if (onStack[vertex])
                    return true;
            } else if (dfs(g, vertex, visited, onStack, schedule))
                return true;
        }
        onStack[start] = false;
        schedule.offer(start);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}, {0, 1}})));
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{0, 1}})));
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
    }
}
