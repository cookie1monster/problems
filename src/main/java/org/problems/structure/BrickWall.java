package org.problems.structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/brick-wall/description/
public class BrickWall {

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (List<Integer> row : wall) {
            int rowLength = 0;
            for (int i = 0; i < row.size() - 1; ++i) {
                rowLength += row.get(i);
                int breckFreq = countMap.getOrDefault(rowLength, 0);
                countMap.put(rowLength, breckFreq + 1);
            }
        }

        int gapCount = -1;
        for (int brickLength : countMap.keySet())
            gapCount = Math.max(gapCount, countMap.get(brickLength));
        return gapCount == -1 ? wall.size() : wall.size() - gapCount;
    }

    public static void main(String[] args) {
        System.out.println(leastBricks(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1),
                Arrays.asList(1))) == 3);

        System.out.println(leastBricks(Arrays.asList(
                Arrays.asList(1, 2, 2, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 1, 1))) == 2);
    }

}
