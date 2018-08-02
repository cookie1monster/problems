package org.problems.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/sliding-puzzle/description/
public class SlidingPuzzle {

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void addNextStep(int index, String str, Set<String> visited, List<String> stepList, int offset) {
        char[] nextStep = str.toCharArray();
        swap(nextStep, index, index + offset);
        String nextStepStr = new String(nextStep);
        if (!visited.contains(nextStepStr)) {
            stepList.add(nextStepStr);
            visited.add(nextStepStr);
        }
    }

    public static int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                sb.append(String.valueOf(board[i][j]));
        String start = sb.toString();

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(start);

        int step = 0;

        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (map.get(step) != null && !map.get(step).isEmpty()) {
            List<String> stepSet = map.get(step);
            ++step;
            map.put(step, new ArrayList<>());
            for (String str : stepSet) {
                if ("123450".equals(str))
                    return step - 1;

                int index = str.indexOf('0');
                List<String> stepList = map.get(step);
                // left
                if (index != 0 && index != 3) {
                    addNextStep(index, str, visited, stepList, -1);
                }
                // right
                if (index != 2 && index != 5) {
                    addNextStep(index, str, visited, stepList, 1);
                }
                // up
                if (index > 2) {
                    addNextStep(index, str, visited, stepList, -3);
                }
                // down
                if (index < 3) {
                    addNextStep(index, str, visited, stepList, 3);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}) == -1);
        System.out.println(slidingPuzzle(new int[][]{{3, 2, 4}, {1, 5, 0}}) == 14);
        System.out.println(slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}) == 5);
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}) == 1);

    }

}
