package org.problems.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

//https://leetcode.com/problems/falling-squares/description/
public class FallingSquares {

    public static List<Integer> fallingSquares(int[][] positions) {

        NavigableSet<int[]> squares = new TreeSet<>((a, b) -> {
            if (a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int[] position : positions) {
            int[] nPos = new int[]{position[0], position[0] + position[1] - 1, position[1]};
            SortedSet<int[]> tmp = squares.tailSet(new int[]{0, position[0], -1});
            for (int[] pos : tmp) {
                if (nPos[1] <= pos[0])
                    break;
                nPos[2] = Math.max(nPos[2], pos[2] + position[1]);
            }
            squares.add(nPos);
            max = Math.max(max, nPos[2]);
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fallingSquares(new int[][]{{2, 82}, {57, 22}, {16, 66}, {46, 15}, {5, 11}, {9, 83}, {1, 32}, {87, 91}, {64, 61}, {87, 53}}));
        System.out.println(fallingSquares(new int[][]{{6, 1}, {9, 2}, {2, 4}}));
        System.out.println(fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
        System.out.println(fallingSquares(new int[][]{{100, 100}, {200, 100}}));

    }
}
